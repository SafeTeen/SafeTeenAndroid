package com.candledle.safeteen.design_system.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
fun SafeButton(
    text: String,
    color: Color,
    onClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = color)
            .clickable(onClick = onClick),
        contentAlignment = Alignment.Center,
    ) {
        Body1(
            text = text,
            color = SafeColor.White,
        )
    }
}