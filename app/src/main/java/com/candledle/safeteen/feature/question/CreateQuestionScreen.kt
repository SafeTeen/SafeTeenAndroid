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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.R
import com.candledle.safeteen.component.Header
import com.candledle.safeteen.design_system.button.SafeLargeButton
import com.candledle.safeteen.design_system.textfield.SafeLargeTextField
import com.candledle.safeteen.design_system.textfield.SafeMediumTextField
import com.candledle.safeteen.design_system.theme.Body1
import com.candledle.safeteen.design_system.theme.SafeColor

@Composable
internal fun CreateQuestion(
    navController: NavController,
) {

    var question by remember { mutableStateOf("") }
    val onQuestionChange = { value: String ->
        question = value
    }

    var description by remember { mutableStateOf("") }
    val onDescriptionChange = { value: String ->
        description = value
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
                hint = stringResource(id = R.string.question_details_enter_answer),
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
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier.imePadding(),
            ) {
                SafeLargeButton(
                    text = stringResource(id = R.string.create_question_do_create),
                    backgroundColor = SafeColor.Main500,
                    onClick = {},
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
        }
    }
}