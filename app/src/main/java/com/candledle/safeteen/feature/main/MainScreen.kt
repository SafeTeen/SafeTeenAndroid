package com.candledle.safeteen.feature.main

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.candledle.safeteen.feature.main.game.GameScreen
import com.candledle.safeteen.feature.main.home.HomeScreen
import com.candledle.safeteen.feature.main.info.InformationScreen
import com.candledle.safeteen.feature.main.mypage.MyPageScreen
import com.candledle.safeteen.feature.shop.ShopScreen
import com.candledle.safeteen.navigation.BottomBar
import com.candledle.safeteen.navigation.SafeNavigation

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen(
    navController: NavController,
) {

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
                HomeScreen(navController = navController)
            }

            composable(SafeNavigation.Navigation.Game) {
                GameScreen(navController = navController)
            }

            composable(SafeNavigation.Navigation.Info) {
                InformationScreen(navController = navController)
            }

            composable(SafeNavigation.Navigation.Shop) {
                ShopScreen(navController = navHostController)
            }

            composable(SafeNavigation.Navigation.MyPage) {
                MyPageScreen(navController = navHostController)
            }
        }
    }
}