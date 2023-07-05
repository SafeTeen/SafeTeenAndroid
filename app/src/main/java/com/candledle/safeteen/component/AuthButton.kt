package com.candledle.safeteen.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.design_system.button.SafeLargeButton
import com.candledle.safeteen.design_system.theme.Body3
import com.candledle.safeteen.design_system.theme.Body4
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun AuthButton(
    buttonText: String,
    onButtonClicked: () -> Unit,
    description: String,
    descriptionColor: Color,
    actionText: String,
    onClickActionText: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        SafeLargeButton(
            text = buttonText,
            backgroundColor = SafeColor.Main500,
            onClick = onButtonClicked,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.safeClickable(
                onClick = onClickActionText,
                rippleEnabled = false,
            ),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Body4(
                text = description,
                color = descriptionColor,
            )
            Spacer(modifier = Modifier.width(8.dp))
            Body3(
                text = actionText,
                color = SafeColor.Main500,
            )
        }
        Spacer(modifier = Modifier.height(44.dp))
    }
}