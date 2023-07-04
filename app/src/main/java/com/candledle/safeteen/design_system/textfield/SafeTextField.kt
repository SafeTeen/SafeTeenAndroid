package com.candledle.safeteen.design_system.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.design_system.theme.Body2
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
fun SafeTextField(
    value: String,
    onValueChanged: (String) -> Unit,
    hint: String,
) {
    BasicTextField(
        value = value,
        onValueChange = onValueChanged,
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(12.dp))
            .border(
                width = 1.dp,
                color = SafeColor.Gray500,
                shape = RoundedCornerShape(12.dp),
            )
            .padding(
                horizontal = 16.dp,
                vertical = 12.dp,
            ),
    ) { innerTextField ->
        Column(
            modifier = Modifier.fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
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