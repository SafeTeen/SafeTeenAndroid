package com.candledle.safeteen.design_system.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.design_system.theme.Body2
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
private fun SafeBasicTextField(
    modifier: Modifier,
    arrangement: Arrangement.Vertical,
    value: String,
    onValueChanged: (String) -> Unit,
    hint: String,
    keyboardType: KeyboardType,
    imeAction: ImeAction,
    error: Boolean,
) {

    var focused by remember { mutableStateOf(false) }

    BasicTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = modifier
            .onFocusChanged {
                focused = it.isFocused
            }
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = if (error) SafeColor.Red
                else if(focused) SafeColor.Main700
                else SafeColor.Gray500,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeAction,
        ),
        singleLine = true,
        visualTransformation = if (keyboardType == KeyboardType.Password || keyboardType == KeyboardType.NumberPassword) PasswordVisualTransformation()
        else VisualTransformation.None,
    ) { innerTextField ->
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = arrangement,
        ) {
            Body2(
                text = if (value.isEmpty()) hint
                else "",
                color = SafeColor.Gray700,
            )
        }
        innerTextField()
    }
}

@Composable
internal fun SafeMediumTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    error: Boolean = false,
) {
    SafeBasicTextField(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        arrangement = Arrangement.Center,
        value = value,
        onValueChanged = onValueChanged,
        hint = hint,
        keyboardType = keyboardType,
        imeAction = imeAction,
        error = error,
    )
}

@Composable
internal fun SafeLargeTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    hint: String,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Done,
    error: Boolean = false
) {
    SafeBasicTextField(
        modifier = Modifier.fillMaxSize(),
        arrangement = Arrangement.Top,
        value = value,
        onValueChanged = onValueChanged,
        hint = hint,
        keyboardType = keyboardType,
        imeAction = imeAction,
        error = error,
    )
}