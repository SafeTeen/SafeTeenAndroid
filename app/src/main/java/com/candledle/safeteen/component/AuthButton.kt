package com.candledle.safeteen.component

import androidx.compose.foundation.clickable
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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.R
import com.candledle.safeteen.design_system.button.SafeButton
import com.candledle.safeteen.design_system.theme.Body3
import com.candledle.safeteen.design_system.theme.Body4
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun AuthButton(
    onButtonClicked: () -> Unit,
    description: String,
    descriptionColor: Color,
    actionText: String,
    onClickActionText: () -> Unit,
){
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        SafeButton(
            text = stringResource(id = R.string.sign_in),
            color = SafeColor.Main500,
            onClick = onButtonClicked,
        )
        Spacer(modifier = Modifier.height(12.dp))
        Row(
            modifier = Modifier.clickable(onClick = onClickActionText),
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