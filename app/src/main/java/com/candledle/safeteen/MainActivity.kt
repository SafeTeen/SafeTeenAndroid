package com.candledle.safeteen

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.candledle.safeteen.design_system.theme.SafeteenTheme
import com.candledle.safeteen.feature.landing.LandingScreen
import com.candledle.safeteen.feature.signin.SignInScreen
import com.candledle.safeteen.feature.signup.SignUpScreen
import com.candledle.safeteen.navigation.SafeNavigation

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SafeteenTheme {

                val navHostController = rememberNavController()

                Scaffold {
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
                        ){
                            SignInScreen(navController = navHostController)
                        }

                        composable(
                            route = SafeNavigation.SignUp,
                        ){
                            SignUpScreen(navController = navHostController)
                        }
                    }
                }
            }
        }
    }
}