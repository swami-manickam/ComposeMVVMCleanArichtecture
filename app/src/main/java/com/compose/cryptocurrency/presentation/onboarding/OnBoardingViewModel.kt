package com.compose.cryptocurrency.presentation.onboarding

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.cryptocurrency.domain.usecase.datastore.SaveAppEntry
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OnBoardingViewModel @Inject constructor(private val saveAppEntry: SaveAppEntry) :
    ViewModel() {


    fun onEvent(event: OnBoardingEvent) {

        when (event) {

            is OnBoardingEvent.SaveAppEntry ->
                saveUserEntry()
        }

    }

    fun saveUserEntry() {
        viewModelScope.launch {
            saveAppEntry()
        }
    }

}