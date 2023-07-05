package com.candledle.safeteen.feature.question

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.R
import com.candledle.safeteen.component.Header
import com.candledle.safeteen.design_system.button.SafeLargeButton
import com.candledle.safeteen.design_system.textfield.SafeTextField
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.Body4
import com.candledle.safeteen.design_system.theme.Heading5
import com.candledle.safeteen.design_system.theme.Heading6
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun QuestionDetailsScreen(
    navController: NavController,
) {

    val answers = remember {
        mutableStateListOf(
            "저는 운동장으로 질주합니다 책상 아래로 가는 하남자가 어딨나용??",
            "괜히 달려서 다치는 것보단 책상 아래가... 더 안전할 듯",
        )
    }

    var answer by remember { mutableStateOf("") }

    val onAnswerChange = { value: String ->
        answer = value
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Spacer(modifier = Modifier.height(20.dp))
        Header(text = "Q&A") {
            navController.popBackStack()
        }
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Question(
                title = "학교에서 지진 났을 때 책상 아래 vs 운동장으로 질주 뭐가 좋을까요?",
                content = "학교에서 지진이 났을 때 책상 아래가 더 안전한가요, 아니면 운동장으로 나가는게 더 안전한가요?",
            )
            Spacer(modifier = Modifier.height(24.dp))
            Divider(
                modifier = Modifier.height(1.dp),
                color = SafeColor.Gray500,
            )
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                items(answers) {
                    Answer(answer = it)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.imePadding(),
            ) {
                Box(modifier = Modifier.weight(0.7f)) {
                    SafeTextField(
                        value = answer,
                        onValueChanged = onAnswerChange,
                        hint = stringResource(id = R.string.question_details_enter_answer),
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier.weight(0.3f)) {
                    SafeLargeButton(
                        text = stringResource(id = R.string.question_details_create),
                        backgroundColor = SafeColor.Main500,
                        onClick = {},
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}

@Composable
private fun Question(
    title: String,
    content: String,
) {
    Column {
        Heading5(text = "Q.")
        Spacer(modifier = Modifier.height(12.dp))
        Heading6(text = title)
        Spacer(modifier = Modifier.height(12.dp))
        Body4(text = content)
    }
}

@Composable
private fun Answer(
    answer: String,
) {
    Body1(text = "A.")
    Spacer(modifier = Modifier.height(4.dp))
    Body4(text = answer)
}