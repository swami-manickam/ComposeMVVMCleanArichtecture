package com.compose.cryptocurrency.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SmallTopAppBar
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.getString
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.cryptocurrency.R
import com.compose.cryptocurrency.presentation.coindetail.CoinDetailScreen
import com.compose.cryptocurrency.presentation.coinlist.CoinListScreen
import com.compose.cryptocurrency.presentation.navigation.CoinBottomNav
import com.compose.cryptocurrency.presentation.navigation.CoinNavGraph
import com.compose.cryptocurrency.presentation.navigation.NavigationGraph
import com.compose.cryptocurrency.presentation.onboarding.OnBoardingScreen
import com.compose.cryptocurrency.presentation.ui.theme.CryptocurrencyAppYTTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalFoundationApi
@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptocurrencyAppYTTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    /*OnBoardingScreen()*/
                    CoinNavGraph(startDestination = /*viewModel.startDestination.value*/Screen.SplashScreen.route)
                }
            }
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun DashboardScreen() {
    val navController = rememberNavController()
    val context = LocalContext.current
    Scaffold(topBar = {
        TopAppBar(
            title = {
                Text(
                    text = getString(context,R.string.app_name),
                    color = MaterialTheme.colors.secondaryVariant
                )
            },
            colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colors.primary)
        )
    }, bottomBar = { CoinBottomNav(navController = navController)}) { innerPadding ->

        NavigationGraph(
            navController = navController,
            Modifier.padding(innerPadding)
        )

        /*val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = Screen.CoinListScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(
                route = Screen.CoinListScreen.route
            ) {
                CoinListScreen(navController = navController)
            }
            composable(
                route = Screen.CoinDetailScreen.route + "/{coinId}"
            ) {
                CoinDetailScreen()
            }
        }*/
    }
}