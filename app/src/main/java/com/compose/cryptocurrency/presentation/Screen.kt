package com.compose.cryptocurrency.presentation

sealed class Screen(val route: String) {

    object SplashScreen : Screen("splash_screen")
    object OnBoardingScreen : Screen("on_boarding")
    object CoinListScreen : Screen("coin_list_screen")
    object CoinDetailScreen : Screen("coin_detail_screen")
}
