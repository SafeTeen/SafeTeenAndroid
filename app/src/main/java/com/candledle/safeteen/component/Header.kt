package com.candledle.safeteen.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.R
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun Header(
    text: String,
    onDismiss: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        contentAlignment = Alignment.Center,
    ) {
        Body1(
            text = text,
            color = SafeColor.Gray900,
        )
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Start,
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            Image(
                modifier = Modifier.safeClickable { onDismiss() },
                painter = painterResource(id = R.drawable.ic_back),
                contentDescription = null,
            )
        }
    }
}