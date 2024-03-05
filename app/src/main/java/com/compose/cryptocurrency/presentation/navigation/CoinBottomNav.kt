package com.compose.cryptocurrency.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.compose.cryptocurrency.R
import com.compose.cryptocurrency.presentation.AnimatedSplashScreen
import com.compose.cryptocurrency.presentation.DashboardScreen
import com.compose.cryptocurrency.presentation.MainViewModel
import com.compose.cryptocurrency.presentation.Screen
import com.compose.cryptocurrency.presentation.coindetail.CoinDetailScreen
import com.compose.cryptocurrency.presentation.coinlist.CoinListScreen
import com.compose.cryptocurrency.presentation.notification.CoinNotificationScreen
import com.compose.cryptocurrency.presentation.onboarding.OnBoardingScreen
import com.compose.cryptocurrency.presentation.onboarding.OnBoardingViewModel
import com.compose.cryptocurrency.presentation.profile.CoinProfileScreen
import com.compose.cryptocurrency.presentation.profile.ProfileViewModel
import com.compose.cryptocurrency.presentation.wallet.WalletScreen

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun CoinBottomNav(navController: NavController) {

    val items = listOf(
        CoinBottomNavItem.CoinHome,
        CoinBottomNavItem.CoinNotification,
        CoinBottomNavItem.CoinProfile
    )

    BottomNavigation(
        backgroundColor = colorResource(id = R.color.primary),
        contentColor = Color.Black
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->

            //
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = {
                    Text(
                        text = item.title,
                        fontSize = 9.sp
                    )
                },
                selectedContentColor = colorResource(id = R.color.white),
                unselectedContentColor = colorResource(id = R.color.dark_gray).copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {

                        navController.graph.startDestinationRoute?.let { screen_route ->
                            popUpTo(screen_route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }

    }
}


@ExperimentalMaterialApi
@Composable
fun NavigationGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        navController,
        startDestination = CoinBottomNavItem.CoinHome.route,
        modifier = modifier
    ) {
        composable(CoinBottomNavItem.CoinHome.route) {
            CoinListScreen(navController = navController)
        }

        composable(CoinBottomNavItem.CoinNotification.route) {
            CoinNotificationScreen()
        }

        composable(CoinBottomNavItem.CoinProfile.route) {
            val viewModel: ProfileViewModel = hiltViewModel()
            CoinProfileScreen(viewModel, navController)
        }

        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }


        composable(
            route = Screen.WalletScreen.route
        ) {
            WalletScreen()
        }

    }
}


@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CoinNavGraph(
    startDestination: String
) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = startDestination) {

        composable(
            route = Screen.SplashScreen.route
        ) {
            val viewModel: MainViewModel = hiltViewModel()
            AnimatedSplashScreen(navController = navController, viewModel)
        }

        composable(route = Screen.OnBoardingScreen.route) {
            val viewModel: OnBoardingViewModel = hiltViewModel()
            OnBoardingScreen(navController = navController,onBoardingEvent = viewModel::onEvent)
        }
        composable(CoinBottomNavItem.CoinHome.route) {
            DashboardScreen()
        }

        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }

    }


}


sealed class CoinBottomNavItem(val route: String, val icon: Int, val title: String) {
    object CoinHome : CoinBottomNavItem("home", R.drawable.ic_baseline_home_24, "Home")
    object CoinNotification : CoinBottomNavItem("notification", R.drawable.ic_baseline_notifications_24, "Notification")
    object CoinProfile : CoinBottomNavItem("profile", R.drawable.ic_baseline_person_24, "Profile")
}
