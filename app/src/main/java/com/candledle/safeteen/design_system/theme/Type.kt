package com.candledle.safeteen.design_system.theme

import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.sp
import com.candledle.safeteen.R

// Set of Material typography styles to start with
val Typography = Typography()

@Stable
private val maxLine = 1000

@Stable
private val pretendardFamily = FontFamily(
    Font(R.font.pretendard_bold, FontWeight.Bold),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_regular, FontWeight.Normal),
)

object SafeTypography{
    private val platFormTextStyle = PlatformTextStyle(
        includeFontPadding = false,
    )

    @Stable
    val h1 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 40.sp,
        lineHeight = 60.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val h2 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 36.sp,
        lineHeight = 54.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val h3 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 32.sp,
        lineHeight = 48.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val h4 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 28.sp,
        lineHeight = 40.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val h5 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 24.sp,
        lineHeight = 36.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val h6 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 28.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val body1 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val body2 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val body3 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val body4 = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 20.sp,
        platformStyle = platFormTextStyle,
    )

    @Stable
    val caption = TextStyle(
        fontFamily = pretendardFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 18.sp,
        platformStyle = platFormTextStyle,
    )
}

@Composable
fun Heading1(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.h1,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Heading2(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.h2,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Heading3(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.h3,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Heading4(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.h4,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Heading5(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.h5,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Heading6(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.h6,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Body1(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.body1,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Body2(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.body2,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Body3(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.body3,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Body4(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.body4,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}

@Composable
fun Caption(
    modifier: Modifier = Modifier,
    color: Color = SafeColor.Black,
    text: String,
    decoration: TextDecoration = TextDecoration.None,
    overflow: TextOverflow = TextOverflow.Ellipsis,
    maxLines: Int = maxLine,
) {
    Text(
        modifier = modifier,
        color = color,
        text = text,
        fontFamily = pretendardFamily,
        style = SafeTypography.caption,
        textDecoration = decoration,
        overflow = overflow,
        maxLines = maxLines,
    )
}