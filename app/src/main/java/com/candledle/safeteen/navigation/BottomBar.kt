package com.candledle.safeteen.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.candledle.safeteen.design_system.theme.Body4
import com.candledle.safeteen.design_system.theme.SafeColor
import com.google.accompanist.insets.LocalWindowInsets


@Composable
internal fun BottomBar(
    navController: NavController,
) {
    val tabs = listOf(
        NavigationItem.Home,
        NavigationItem.Game,
        NavigationItem.Info,
        NavigationItem.Shop,
        NavigationItem.MyPage,
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val localWindowInset = with(LocalDensity.current) {
        LocalWindowInsets.current.navigationBars.bottom.toDp()
    }

    Column {
        BottomNavigation(
            modifier = Modifier
                .height(68.dp)
                .padding(bottom = localWindowInset)
                .graphicsLayer(
                    clip = true,
                    shape = RoundedCornerShape(
                        topStart = 16.dp,
                        topEnd = 16.dp,
                    ),
                    shadowElevation = 10f,
                ),
            backgroundColor = SafeColor.White,
        ) {

            val currentDestination = navBackStackEntry?.destination?.route

            tabs.forEach { tab ->

                val selected = currentDestination == tab.route

                BottomNavigationItem(
                    selected = selected,
                    onClick = {
                        navController.navigate(tab.route)
                    },
                    icon = {
                        Icon(
                            modifier = Modifier.padding(
                                bottom = 8.dp,
                            ),
                            painter = painterResource(id = tab.drawableId),
                            contentDescription = stringResource(id = tab.stringResId),
                        )
                    },
                    selectedContentColor = SafeColor.Black,
                    unselectedContentColor = SafeColor.Gray500,
                    label = {
                        Body4(
                            text = stringResource(id = tab.stringResId),
                            color = if (selected) SafeColor.Black
                            else SafeColor.Gray500,
                        )
                    },
                    alwaysShowLabel = true,
                )
            }
        }
        Spacer(
            modifier = Modifier
                .fillMaxWidth()
                .height(14.dp)
                .background(color = SafeColor.White)
        )
    }
}