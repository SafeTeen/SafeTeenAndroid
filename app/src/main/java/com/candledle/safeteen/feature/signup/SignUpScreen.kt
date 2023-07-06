package com.candledle.safeteen.feature.signup

import android.util.Log
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.PrefKey
import com.candledle.safeteen.R
import com.candledle.safeteen.component.AuthButton
import com.candledle.safeteen.component.SafeTeenHeader
import com.candledle.safeteen.design_system.textfield.SafeMediumTextField
import com.candledle.safeteen.design_system.theme.SafeColor
import com.candledle.safeteen.getPreferences
import com.candledle.safeteen.navigation.SafeNavigation
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

@Composable
fun SignUpScreen(
    navController: NavController,
) {

    val context = LocalContext.current

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

    var error by remember { mutableStateOf(false) }

    val onSignUpButtonClicked = {
        runBlocking {
            delay(1000)
        }
        if (password == passwordRepeat) {
            with(getPreferences(context).edit()) {
                putString(PrefKey.User.name, nickName)
                putString(PrefKey.User.password, password)
                putInt(PrefKey.User.reward, 2000)
                putString(PrefKey.User.id, id)
            }.apply()

            navController.navigate(SafeNavigation.SignIn) {
                popUpTo(SafeNavigation.SignUp) {
                    inclusive = true
                }
            }
        } else {
            error = true
        }
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
            SafeMediumTextField(
                value = nickName,
                onValueChanged = onNickNameChange,
                hint = stringResource(id = R.string.sign_up_nick_name),
            )
            Spacer(modifier = Modifier.height(12.dp))
            SafeMediumTextField(
                value = id,
                onValueChanged = onIdChange,
                hint = stringResource(id = R.string.sign_in_id),
            )
            Spacer(modifier = Modifier.height(12.dp))
            SafeMediumTextField(
                value = password,
                onValueChanged = onPasswordChange,
                hint = stringResource(id = R.string.sign_in_password),
                keyboardType = KeyboardType.Password,
            )
            Spacer(modifier = Modifier.height(12.dp))
            SafeMediumTextField(
                value = passwordRepeat,
                onValueChanged = onPasswordRepeatChange,
                hint = stringResource(id = R.string.sign_up_password_repeat),
                keyboardType = KeyboardType.Password,
                error = error,
            )
            Spacer(modifier = Modifier.weight(1f))
            Column(
                modifier = Modifier.imePadding(),
            ) {
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
}