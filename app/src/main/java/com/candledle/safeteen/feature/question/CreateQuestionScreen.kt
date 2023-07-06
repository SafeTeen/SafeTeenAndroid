package com.candledle.safeteen.feature.question

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.candledle.safeteen.design_system.textfield.SafeLargeTextField
import com.candledle.safeteen.design_system.textfield.SafeMediumTextField
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.SafeColor
import com.candledle.safeteen.getList
import com.candledle.safeteen.getPreferences
import com.candledle.safeteen.putList
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
internal fun CreateQuestion(
    navController: NavController,
) {

    val focusManager = LocalFocusManager.current

    val context = LocalContext.current
    val preference = getPreferences(context = context)
    val editor = preference.edit()

    val questions = preference.getList(PrefKey.Common.qnas).toMutableList()
    val myQuestions = preference.getList(PrefKey.User.qnas).toMutableList()
    val descriptions = preference.getList(PrefKey.Common.descriptions).toMutableList()
    val myDescriptions = preference.getList(PrefKey.User.descriptions).toMutableList()

    var questionError by remember { mutableStateOf(false) }
    var descriptionError by remember { mutableStateOf(false) }

    var question by remember { mutableStateOf("") }
    val onQuestionChange = { value: String ->
        question = value
    }

    var description by remember { mutableStateOf("") }
    val onDescriptionChange = { value: String ->
        description = value
    }

    val onCreateButtonClicked = {
        if(question.isBlank()) questionError = true
        else if(description.isBlank()) descriptionError = true
        else{
            runBlocking {
                questionError = false
                descriptionError = false
                questions.add(question)
                myQuestions.add(question)
                descriptions.add(description)
                myDescriptions.add(description)
                editor.apply {
                    putList(PrefKey.Common.qnas, questions)
                    putList(PrefKey.User.qnas, myQuestions)
                    putList(PrefKey.Common.descriptions, descriptions)
                    putList(PrefKey.User.descriptions, myDescriptions)
                }.apply()
                delay(1000)
                focusManager.clearFocus()
                navController.popBackStack()
            }
        }
        Unit
    }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Header(text = "Q&A 작성") {
                navController.popBackStack()
            }
            Spacer(modifier = Modifier.height(8.dp))
            Body1(text = stringResource(id = R.string.create_question_question))
            Spacer(modifier = Modifier.height(8.dp))
            SafeMediumTextField(
                value = question,
                onValueChanged = onQuestionChange,
                hint = stringResource(id = R.string.create_question_enter_question),
                error = questionError
            )
            Spacer(modifier = Modifier.height(24.dp))
            Body1(text = stringResource(id = R.string.create_question_description))
            Spacer(modifier = Modifier.height(8.dp))
            Box(
                modifier = Modifier.height(196.dp),
            ) {
                SafeLargeTextField(
                    value = description,
                    onValueChanged = onDescriptionChange,
                    hint = stringResource(id = R.string.create_question_enter_question_description),
                    error = descriptionError,
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier.imePadding(),
            ) {
                SafeLargeButton(
                    text = stringResource(id = R.string.create_question_do_create),
                    backgroundColor = SafeColor.Main500,
                    onClick = onCreateButtonClicked,
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}