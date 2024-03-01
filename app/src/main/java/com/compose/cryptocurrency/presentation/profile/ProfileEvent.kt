package com.compose.cryptocurrency.presentation.profile

sealed class ProfileEvent {
    data class PerformLogout(val onClick : () ->Unit) :ProfileEvent()

}