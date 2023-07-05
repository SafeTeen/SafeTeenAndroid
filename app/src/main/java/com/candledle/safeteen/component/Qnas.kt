package com.candledle.safeteen.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.design_system.theme.Body3
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun MyQnas(
    questions: List<String>,
    backgroundColor: Color,
    navController: NavController,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        items(questions.size) { index ->
            MyQna(
                question = questions[index],
                backgroundColor = backgroundColor,
            ) {
                navController.navigate("createQuestion/$index")
            }
        }
    }
}

@Composable
internal fun MyQna(
    question: String,
    questionColor: Color = SafeColor.Black,
    backgroundColor: Color,
    onClick: (() -> Unit)? = null,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .defaultMinSize(minHeight = 44.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onClick?.invoke() }
            .background(color = backgroundColor)
            .padding(12.dp),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.Top,
    ) {
        Body3(text = "Q.")
        Spacer(modifier = Modifier.width(8.dp))
        Body3(
            text = question,
            color = questionColor,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )
    }
}