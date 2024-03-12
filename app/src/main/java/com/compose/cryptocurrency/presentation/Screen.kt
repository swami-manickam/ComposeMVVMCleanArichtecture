package com.compose.cryptocurrency.presentation

sealed class Screen(val route: String) {

    object SplashScreen : Screen("splash_screen")
    object OnBoardingScreen : Screen("on_boarding")
    object CoinListScreen : Screen("coin_list_screen")
    object CoinDetailScreen : Screen("coin_detail_screen")
    object WalletScreen : Screen("wallet_screen")
    object HeartRateScreen : Screen("heart_rate_screen")
    object PAIScreen : Screen("pai_screen")
}
