package com.compose.cryptocurrency.presentation.onboarding

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.compose.cryptocurrency.presentation.Dimens
import com.compose.cryptocurrency.presentation.commonview.CoinButton
import com.compose.cryptocurrency.presentation.commonview.CoinTextButton
import com.compose.cryptocurrency.presentation.onboarding.components.OnBoardingPage
import com.compose.cryptocurrency.presentation.onboarding.components.PageIndicator
import kotlinx.coroutines.launch


@ExperimentalFoundationApi
@Composable
fun OnBoardingScreen() {

    Column(modifier = Modifier.fillMaxSize().background(MaterialTheme.colors.primary)) {
        val pageState = rememberPagerState(initialPage = 0) {
            pageList.size
        }

        val buttonState = remember {
            derivedStateOf {
                when (pageState.currentPage) {
                    0 -> listOf("", "Next")
                    1 -> listOf("Back", "Next")
                    2 -> listOf("Back", "Get Started")
                    else -> listOf("", "")
                }
            }
        }

        HorizontalPager(state = pageState) { index ->
            OnBoardingPage(Modifier.padding(0.dp), page = pageList[index])
        }
        Spacer(modifier = Modifier.weight(1f))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = Dimens.smallPadding3)
                .navigationBarsPadding(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {

            Row(verticalAlignment = Alignment.CenterVertically,
                /*modifier = Modifier.weight(1.5f).fillMaxSize().fillMaxWidth()*/) {
                val scope = rememberCoroutineScope()
                if (buttonState.value[0].isNotEmpty()) {

                    CoinTextButton(modifier = /*Modifier.weight(0.5f).fillMaxSize()*/Modifier.padding(0.dp),
                        text = buttonState.value[0], onClick = {
                        scope.launch {
                            pageState.animateScrollToPage(page = pageState.currentPage - 1)
                        }
                    })
                }

                PageIndicator(
                    modifier = Modifier.width(52.dp),
                    pageSize = pageList.size,
                    selectedPage = pageState.currentPage
                )
                Spacer(modifier = Modifier.padding(Dimens.smallPadding1))

                CoinButton(modifier = Modifier.padding(0.dp)/*Modifier.weight(0.5f)*/,text = buttonState.value[1],
                    onClick = {
                        scope.launch {
                            if (pageState.currentPage == 3) {
                                //Navigate to the main screen and save a value in datastore preferences
                            } else {
                                pageState.animateScrollToPage(page = pageState.currentPage + 1)
                            }
                        }
                    })
            }


        }


        Spacer(modifier = Modifier.weight(0.2f))
    }
}