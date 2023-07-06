package com.candledle.safeteen.design_system.button

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.Caption
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
private fun SafeBasicButton(
    modifier: Modifier = Modifier,
    color: Color,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    Box(
        modifier = modifier
            .background(color = color)
            .clickable(onClick = onClick)
            .padding(horizontal = 12.dp),
        contentAlignment = Alignment.Center,
    ) {
        content()
    }
}

@Composable
fun SafeSmallButton(
    text: String,
    textColor: Color = SafeColor.White,
    backgroundColor: Color,
    onClick: () -> Unit,
) {
    SafeBasicButton(
        modifier = Modifier
            .defaultMinSize(minWidth = 48.dp)
            .height(26.dp)
            .clip(RoundedCornerShape(50.dp)),
        color = backgroundColor,
        onClick = onClick,
    ) {
        Caption(
            text = text,
            color = textColor,
        )
    }
}

@Composable
fun SafeMediumButton(
    text: String,
    textColor: Color = SafeColor.White,
    backgroundColor: Color,
    onClick: () -> Unit,
) {
    SafeBasicButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .clip(RoundedCornerShape(4.dp)),
        color = backgroundColor,
        onClick = onClick,
    ) {
        Caption(
            text = text,
            color = textColor,
        )
    }
}

@Composable
fun SafeLargeButton(
    text: String,
    textColor: Color = SafeColor.White,
    backgroundColor: Color,
    onClick: () -> Unit,
) {
    SafeBasicButton(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(8.dp)),
        color = backgroundColor,
        onClick = onClick,
    ) {
        Body1(
            text = text,
            color = textColor,
        )
    }
}