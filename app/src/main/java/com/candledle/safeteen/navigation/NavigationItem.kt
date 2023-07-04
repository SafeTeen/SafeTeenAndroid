package com.candledle.safeteen.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import com.candledle.safeteen.R

sealed class NavigationItem(
    @DrawableRes val drawableId: Int,
    @StringRes val stringResId: Int,
    val route: String,
) {
    object Home : NavigationItem(
        drawableId = R.drawable.ic_home,
        stringResId = R.string.navigation_home,
        route = SafeNavigation.Navigation.Home,
    )

    object Game : NavigationItem(
        drawableId = R.drawable.ic_game,
        stringResId = R.string.navigation_game,
        route = SafeNavigation.Navigation.Game,
    )

    object Info : NavigationItem(
        drawableId = R.drawable.ic_search,
        stringResId = R.string.navigation_info,
        route = SafeNavigation.Navigation.Info,
    )

    object Shop : NavigationItem(
        drawableId = R.drawable.ic_shop,
        stringResId = R.string.navigation_shop,
        route = SafeNavigation.Navigation.Shop,
    )

    object MyPage : NavigationItem(
        drawableId = R.drawable.ic_my_page,
        stringResId = R.string.navigation_my_page,
        route = SafeNavigation.Navigation.MyPage,
    )
}