package com.compose.cryptocurrency.presentation.profile

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    /*private val repository: LoginRepository*/
) : ViewModel() {


    fun onEvent(event: ProfileEvent) {
        when (event) {
            is ProfileEvent.PerformLogout -> {
                viewModelScope.launch() {
                    /*repository.toggleLoginState()*/
                    event.onClick()
                }
            }

            else -> {}
        }
    }

    val themeState = mutableStateOf(false)

    fun updateTheme(updatedTheme: Boolean) {
        themeState.value = updatedTheme
    }


}



