package com.candledle.safeteen

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.candledle.safeteen.design_system.theme.SafeteenTheme
import com.candledle.safeteen.feature.landing.LandingScreen
import com.candledle.safeteen.feature.main.MainScreen
import com.candledle.safeteen.feature.manual.ManualDetailsScreen
import com.candledle.safeteen.feature.question.CreateQuestion
import com.candledle.safeteen.feature.question.QuestionDetailsScreen
import com.candledle.safeteen.feature.signin.SignInScreen
import com.candledle.safeteen.feature.signup.SignUpScreen
import com.candledle.safeteen.navigation.SafeNavigation

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.R)
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        setContent {

            SafeteenTheme {

                val navHostController = rememberNavController()

                NavHost(
                    navController = navHostController,
                    startDestination = SafeNavigation.Landing,
                ) {
                    composable(
                        route = SafeNavigation.Landing,
                    ) {
                        LandingScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.SignIn,
                    ) {
                        SignInScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.SignUp,
                    ) {
                        SignUpScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.Main,
                    ) {
                        MainScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.CreateQuestion
                    ) {
                        CreateQuestion(navController = navHostController)
                    }
                    
                    composable(
                        route = SafeNavigation.QuestionDetails,
                    ){
                        QuestionDetailsScreen(navController = navHostController)
                    }

                    composable(
                        route = SafeNavigation.ManualDetails,
                    ){
                        ManualDetailsScreen(navController = navHostController)
                    }
                }
            }
        }
    }
}