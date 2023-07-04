package com.candledle.safeteen.feature.signin

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

@Composable
fun SignInScreen(
    navController: NavController,
) {

    var id by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    val onIdChange = { value: String ->
        id = value
    }

    val onPasswordChange = { value: String ->
        password = value
    }

    val onButtonClicked = {

    }

    val onClickActionText = {

    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Column(
            modifier = Modifier.padding(horizontal = 16.dp),
        ) {
            Spacer(modifier = Modifier.height(16.dp))
            SafeTeenHeader()
            Spacer(modifier = Modifier.height(24.dp))
            SafeTextField(
                value = id,
                onValueChanged = onIdChange,
                hint = stringResource(id = R.string.sign_in_id),
            )
            Spacer(modifier = Modifier.height(12.dp))
            SafeTextField(
                value = password,
                onValueChanged = onPasswordChange,
                hint = stringResource(id = R.string.sign_in_password),
            )
            Spacer(modifier = Modifier.weight(1f))
            AuthButton(
                onButtonClicked = onButtonClicked,
                description = stringResource(id = R.string.sign_in_no_account),
                descriptionColor = SafeColor.Gray700,
                actionText = stringResource(id = R.string.sign_in_do_sign_up),
                onClickActionText = onClickActionText,
            )
        }
    }
}