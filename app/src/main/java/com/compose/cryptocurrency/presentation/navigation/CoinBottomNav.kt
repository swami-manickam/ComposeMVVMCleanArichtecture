package com.compose.cryptocurrency.presentation.navigation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.compose.cryptocurrency.R
import com.compose.cryptocurrency.presentation.Screen
import com.compose.cryptocurrency.presentation.coindetail.CoinDetailScreen
import com.compose.cryptocurrency.presentation.coinlist.CoinListScreen
import com.compose.cryptocurrency.presentation.notification.CoinNotificationScreen
import com.compose.cryptocurrency.presentation.profile.CoinProfileScreen

@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun CoinBottomNav(navController: NavController) {

    val items = listOf(
        CoinBottomNavItem.CoinHome,
        CoinBottomNavItem.CoinProfile,
        CoinBottomNavItem.CoinNotification
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
                label = { Text(text = item.title,
                    fontSize = 9.sp) },
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



@Composable
fun NavigationGraph(navController: NavHostController,modifier : Modifier) {
    NavHost(navController, startDestination = CoinBottomNavItem.CoinHome.route,modifier = modifier) {
        composable(CoinBottomNavItem.CoinHome.route) {
            CoinListScreen(navController = navController)
        }
        composable(CoinBottomNavItem.CoinProfile.route) {
            CoinProfileScreen()
        }
        composable(CoinBottomNavItem.CoinNotification.route) {
            CoinNotificationScreen()
        }

        composable(
            route = Screen.CoinDetailScreen.route + "/{coinId}"
        ) {
            CoinDetailScreen()
        }

    }
}


sealed class CoinBottomNavItem(val route: String, val icon: Int, val title: String) {

    object CoinHome : CoinBottomNavItem("home", R.drawable.ic_home, "Home")
    object CoinNotification : CoinBottomNavItem("notification", R.drawable.ic_notification, "Notification")
    object CoinProfile : CoinBottomNavItem("profile", R.drawable.ic_profile, "Profile")

}
