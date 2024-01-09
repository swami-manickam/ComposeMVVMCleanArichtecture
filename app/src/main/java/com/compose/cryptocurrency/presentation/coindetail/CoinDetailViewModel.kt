package com.compose.cryptocurrency.presentation.coindetail

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.compose.cryptocurrency.common.AppConstants
import com.compose.cryptocurrency.domain.usecase.coininfo.GetCoinUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(CoinDetailState())
    val state: State<CoinDetailState> = _state

    init {
        savedStateHandle.get<String>(AppConstants.COIN_PARAM_ID)?.let { coinId ->
            getCoin(coinId = coinId)
        }
    }

    private fun getCoin(coinId: String) {
        getCoinUseCase(coinId).onEach { result ->
            when (result) {
                is com.compose.cryptocurrency.common.Resource.Success -> {
                    _state.value = CoinDetailState(
                        isLoading = false, coin = result.data
                    )

                }
                is com.compose.cryptocurrency.common.Resource.Error -> {
                    _state.value = CoinDetailState(
                        isLoading = false, error = result.message ?: "An unexpected error occurred"
                    )
                }
                is com.compose.cryptocurrency.common.Resource.Loading -> {
                    _state.value = CoinDetailState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }
}