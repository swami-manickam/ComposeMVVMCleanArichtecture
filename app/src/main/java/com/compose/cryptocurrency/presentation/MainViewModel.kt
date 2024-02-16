package com.compose.cryptocurrency.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.cryptocurrency.domain.usecase.datastore.ReadAppEntry

import com.compose.cryptocurrency.presentation.navigation.CoinBottomNavItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(private val readAppEntry: ReadAppEntry) : ViewModel() {


    private val _splashCondition = mutableStateOf(true)
    val splashCondition: State<Boolean> = _splashCondition


    private val _startDestination = mutableStateOf(Screen.OnBoardingScreen.route)
    val startDestination: State<String> = _startDestination


    init {
        readAppEntry().onEach { shouldStartFromHomeScreen ->

            if (shouldStartFromHomeScreen)
                _startDestination.value = CoinBottomNavItem.CoinHome.route
            else
                _startDestination.value = Screen.OnBoardingScreen.route
            delay(300) //Without this delay, the onBoarding screen will show for a momentum.
            _splashCondition.value = false
        }.launchIn(viewModelScope)
    }


}