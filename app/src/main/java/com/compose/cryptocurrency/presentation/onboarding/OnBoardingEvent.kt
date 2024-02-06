package com.compose.cryptocurrency.presentation.onboarding

sealed class OnBoardingEvent {
    object SaveAppEntry : OnBoardingEvent()
}