package com.candledle.safeteen.feature.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.candledle.safeteen.feature.main.info.InformationScreen
import com.candledle.safeteen.feature.main.mypage.MyPageScreen
import com.candledle.safeteen.navigation.BottomBar
import com.candledle.safeteen.navigation.SafeNavigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen() {

    val scaffoldState = rememberScaffoldState()

    val navHostController = rememberNavController()

    Scaffold(
        scaffoldState = scaffoldState,
        bottomBar = { BottomBar(navController = navHostController) },
    ) {
        NavHost(
            navController = navHostController,
            startDestination = SafeNavigation.Navigation.Home,
        ) {
            composable(SafeNavigation.Navigation.Home) {

            }

            composable(SafeNavigation.Navigation.Game) {

            }

            composable(SafeNavigation.Navigation.Info) {
                InformationScreen(navController = navHostController)
            }

            composable(SafeNavigation.Navigation.Shop) {

            }

            composable(SafeNavigation.Navigation.MyPage) {
                MyPageScreen(navController = navHostController)
            }
        }
    }
}