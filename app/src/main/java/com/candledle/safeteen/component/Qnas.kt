package com.candledle.safeteen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.candledle.safeteen.design_system.theme.Body3
import com.candledle.safeteen.design_system.theme.SafeColor
import com.candledle.safeteen.feature.main.mypage.QnA

@Composable
internal fun MyQnas(
    questions: List<QnA>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(questions) {
            MyQna(question = it.question)
        }
    }
}

@Composable
internal fun MyQna(
    question: String,
    questionColor: Color = SafeColor.Black,
    onClick: (() -> Unit)? = null,
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 44.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick?.invoke() }
            .background(color = SafeColor.White)
            .padding(12.dp),
        verticalArrangement = Arrangement.Center,
    ) {
        Body3(
            text = question,
            color = questionColor,
        )
    }
}