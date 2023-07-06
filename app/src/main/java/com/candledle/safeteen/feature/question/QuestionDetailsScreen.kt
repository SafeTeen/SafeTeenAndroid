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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.PrefKey
import com.candledle.safeteen.R
import com.candledle.safeteen.component.Header
import com.candledle.safeteen.design_system.button.SafeLargeButton
import com.candledle.safeteen.design_system.textfield.SafeMediumTextField
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.Body4
import com.candledle.safeteen.design_system.theme.Heading5
import com.candledle.safeteen.design_system.theme.Heading6
import com.candledle.safeteen.design_system.theme.SafeColor
import com.candledle.safeteen.getList
import com.candledle.safeteen.getPreferences
import com.candledle.safeteen.putList
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
internal fun QuestionDetailsScreen(
    navController: NavController,
    index: Int,
) {

    val focusManager = LocalFocusManager.current

    val context = LocalContext.current
    val preference = getPreferences(context)

    val question = preference.getList(PrefKey.Common.qnas)[index]
    val description = preference.getList(PrefKey.Common.descriptions)[index]

    val totalAnswers = remember { mutableStateListOf<String>() }
    val answers = remember { mutableStateListOf<String>() }

    LaunchedEffect(Unit) {
        totalAnswers.addAll(preference.getList(PrefKey.Common.answers))
        if(totalAnswers.size - 1 >= index) {
            answers.addAll(totalAnswers[index].split(","))
        }
    }

    var answer by remember { mutableStateOf("") }

    var answerError by remember { mutableStateOf(false) }

    val onAnswerChange = { value: String ->
        answer = value
    }

    val onCreateAnswerButtonClicked = {
        if (answer.isBlank()) {
            answerError = true
        } else {
            runBlocking {
                delay(1500)
            }
            focusManager.clearFocus()
            answers.add(answer)
            if(totalAnswers.size -1 >= index) {
                totalAnswers[index] =
                    answers.toList().toString().replace("[", " ").replace("]", " ").trim()
            }else {
                totalAnswers.add(answers.toList().toString().replace("[", " ").replace("]", " ").trim())
            }
            preference.edit().apply {
                putList(PrefKey.Common.answers, totalAnswers.toList())
            }.apply()
            answer = ""
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Header(text = "Q&A") {
                navController.popBackStack()
            }
            Question(
                title = question,
                content = description,
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
                items(answers.toList()) {
                    Answer(answer = it)
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            Row(
                modifier = Modifier.imePadding(),
            ) {
                Box(modifier = Modifier.weight(0.7f)) {
                    SafeMediumTextField(
                        value = answer,
                        onValueChanged = onAnswerChange,
                        hint = stringResource(id = R.string.question_details_enter_answer),
                        error = answerError,
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                Box(modifier = Modifier.weight(0.3f)) {
                    SafeLargeButton(
                        text = stringResource(id = R.string.question_details_create),
                        backgroundColor = SafeColor.Main500,
                        onClick = onCreateAnswerButtonClicked,
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