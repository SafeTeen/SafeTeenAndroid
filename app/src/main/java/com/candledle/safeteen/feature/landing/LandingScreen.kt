package com.candledle.safeteen.feature.landing

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.candledle.safeteen.R
import com.candledle.safeteen.component.AuthButton
import com.candledle.safeteen.component.Logo
import com.candledle.safeteen.design_system.theme.Heading3
import com.candledle.safeteen.design_system.theme.Heading6
import com.candledle.safeteen.design_system.theme.SafeColor
import com.candledle.safeteen.navigation.SafeNavigation

@Composable
internal fun LandingScreen(
    navController: NavController,
) {

    val onSignInButtonClick = {
        navController.navigate(SafeNavigation.SignIn){
            popUpTo(SafeNavigation.SignIn){
                inclusive = true
            }
        }
    }

    val onClickActionText = {
        navController.navigate(SafeNavigation.SignUp){
            popUpTo(SafeNavigation.SignUp){
                inclusive = true
            }
        }
    }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            modifier = Modifier
                .background(color = SafeColor.Black)
                .alpha(0.6f)
                .fillMaxSize(),
            painter = painterResource(id = R.drawable.ic_landing_background),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(88.dp))
            Heading6(
                text = stringResource(id = R.string.landing_slogan),
                color = SafeColor.White,
            )
            Spacer(modifier = Modifier.height(14.dp))
            Heading3(
                text = stringResource(id = R.string.landing_safeteen),
                color = SafeColor.White,
            )
            Spacer(modifier = Modifier.height(44.dp))
            Logo()
            Spacer(modifier = Modifier.weight(1f))
            AuthButton(
                buttonText = stringResource(id = R.string.sign_up),
                onButtonClicked = onSignInButtonClick,
                description = stringResource(id = R.string.sign_in_no_account),
                descriptionColor = SafeColor.White,
                actionText = stringResource(id = R.string.sign_in_do_sign_up),
                onClickActionText = onClickActionText,
            )
        }
    }
}