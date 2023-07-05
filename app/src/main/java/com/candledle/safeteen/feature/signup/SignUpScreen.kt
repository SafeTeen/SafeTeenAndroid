package com.candledle.safeteen.feature.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.R
import com.candledle.safeteen.component.AuthButton
import com.candledle.safeteen.component.SafeTeenHeader
import com.candledle.safeteen.design_system.textfield.SafeTextField
import com.candledle.safeteen.design_system.theme.SafeColor
import com.candledle.safeteen.navigation.SafeNavigation

@Composable
fun SignUpScreen(
    navController: NavController,
) {

    var nickName by remember { mutableStateOf("") }
    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var passwordRepeat by remember { mutableStateOf("") }

    val onNickNameChange = { value: String ->
        nickName = value
    }

    val onIdChange = { value: String ->
        id = value
    }

    val onPasswordChange = { value: String ->
        password = value
    }

    val onPasswordRepeatChange = { value: String ->
        passwordRepeat = value
    }

    val onSignUpButtonClicked = {

    }

    val onClickActionText = {
        navController.navigate(SafeNavigation.SignIn) {
            popUpTo(SafeNavigation.SignIn) {
                inclusive = true
            }
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(48.dp))
            SafeTeenHeader()
            Spacer(modifier = Modifier.height(24.dp))
            SafeTextField(
                value = id,
                onValueChanged = onIdChange,
                hint = stringResource(id = R.string.sign_up_nick_name),
            )
            Spacer(modifier = Modifier.height(12.dp))
            SafeTextField(
                value = id,
                onValueChanged = onIdChange,
                hint = stringResource(id = R.string.sign_in_id),
            )
            Spacer(modifier = Modifier.height(12.dp))
            SafeTextField(
                value = id,
                onValueChanged = onIdChange,
                hint = stringResource(id = R.string.sign_in_password),
            )
            Spacer(modifier = Modifier.height(12.dp))
            SafeTextField(
                value = password,
                onValueChanged = onPasswordChange,
                hint = stringResource(id = R.string.sign_up_password_repeat),
            )
            Spacer(modifier = Modifier.weight(1f))
            AuthButton(
                buttonText = stringResource(id = R.string.sign_up),
                onButtonClicked = onSignUpButtonClicked,
                description = stringResource(id = R.string.sign_up_have_account),
                descriptionColor = SafeColor.Gray700,
                actionText = stringResource(id = R.string.sign_up_do_sign_in),
                onClickActionText = onClickActionText,
            )
        }
    }
}