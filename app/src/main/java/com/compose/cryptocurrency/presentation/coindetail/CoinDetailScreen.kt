package com.compose.cryptocurrency.presentation.coindetail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.compose.cryptocurrency.R
import com.compose.cryptocurrency.presentation.coindetail.components.CoinTag
import com.compose.cryptocurrency.presentation.coindetail.components.TeamListItem

@Composable
fun CoinDetailScreen(
    viewModel: CoinDetailViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(modifier = Modifier.fillMaxSize()) {
        state.coin?.let { coinDetail ->
            LazyColumn(
                modifier = Modifier.fillMaxSize(), contentPadding = PaddingValues(20.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {
                        Text(
                            text = "${coinDetail.rank}. ${coinDetail.name} (${coinDetail.symbol})",
                            style = MaterialTheme.typography.h2,
                            modifier = Modifier.weight(8f),
                            color = MaterialTheme.colors.primaryVariant
                        )
                        Text(
                            text = if (coinDetail.isActive) stringResource(R.string.active) else stringResource(R.string.inactive),
                            color = if (coinDetail.isActive) MaterialTheme.colors.onPrimary else MaterialTheme.colors.onSecondary,
                            fontStyle = FontStyle.Italic,
                            textAlign = TextAlign.End,
                            modifier = Modifier
                                .align(CenterVertically)
                                .weight(2f)
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = coinDetail.description, style = MaterialTheme.typography.body2,
                        color = MaterialTheme.colors.secondary
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(R.string.tags), style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.primaryVariant
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    com.google.accompanist.flowlayout.FlowRow(
                        mainAxisSpacing = 10.dp,
                        crossAxisSpacing = 10.dp,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        coinDetail.tags.forEach { tag ->
                            CoinTag(tag = tag)
                        }

                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Text(
                        text = stringResource(R.string.team_members), style = MaterialTheme.typography.h3,
                        color = MaterialTheme.colors.primaryVariant
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                }
                items(coinDetail.team){ teamMember ->
                    TeamListItem(teamMember = teamMember, modifier = Modifier
                        .fillMaxWidth()
                        .padding(10.dp))
                    Divider()
                }
            }
        }

        if (state.error.isNotEmpty()) {
            Text(
                text = state.error,
                color = MaterialTheme.colors.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .align(Alignment.Center)
            )
        }
        if (state.isLoading) {
            CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
        }
    }

}