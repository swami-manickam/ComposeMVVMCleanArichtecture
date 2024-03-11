@file:OptIn(ExperimentalFoundationApi::class, ExperimentalFoundationApi::class)
@file:Suppress("CAST_NEVER_SUCCEEDS")

package com.compose.cryptocurrency.presentation.notification

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.compose.cryptocurrency.R
import com.google.accompanist.pager.HorizontalPagerIndicator
import kotlinx.coroutines.launch


data class PagerData(val imageUrl: Int, val caption: String)

val contentList = listOf(
    PagerData(R.drawable.ic_pager_1, "Bitcoin as a digital version of gold"),
    PagerData(R.drawable.ic_pager_2, "Bitcoin as a digital version of gold"),
    PagerData(R.drawable.ic_pager_1, "Bitcoin as a digital version of gold"),
    PagerData(R.drawable.ic_pager_2, "Bitcoin as a digital version of gold"),
    PagerData(R.drawable.ic_pager_1, "Bitcoin as a digital version of gold"),
    PagerData(R.drawable.ic_pager_2, "Bitcoin as a digital version of gold"),
    PagerData(R.drawable.ic_pager_1, "Bitcoin as a digital version of gold")
)

@ExperimentalFoundationApi
@Composable
fun CoinNotificationScreen() {

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(colorResource(id = R.color.white))
    ) {
        /*Text(
            text = "Notification Screen",
            fontWeight = FontWeight.Bold,
            color = colorResource(id = R.color.primary),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )*/

        HorizontalPagerWithIndicators()

        LazyVerticalGrid(modifier = Modifier.padding(8.dp),
            columns = GridCells.Fixed(2),) {
            items(count = 20) {
                NotificationCardItem()
            }
        }
    }
}


@Composable
fun NotificationCardItem() {

    Card(
        modifier = Modifier
            .width(180.dp)
            .height(180.dp)
            .padding(8.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.background),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Box {
                Icon(
                    painter = painterResource(id = R.drawable.ic_splash_bitcoin),
                    contentDescription = "",
                    tint = Color.Unspecified
                )
            }

            Text(
                modifier = Modifier.padding(top = 8.dp),
                text = "Bitcoin ", color = MaterialTheme.colors.primaryVariant,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.body2
            )
            Text(
                text = "Worldwide Payment System", color = MaterialTheme.colors.primaryVariant,
                style = MaterialTheme.typography.body2,
                textAlign = TextAlign.Center
            )

        }
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun HorizontalPagerWithIndicators() {

    val pagerState = rememberPagerState(initialPage = 0,
        initialPageOffsetFraction = 0.5f, pageCount = { contentList.size })
    val coroutineScope = rememberCoroutineScope()
    Column(modifier = Modifier.padding(16.dp)) {
        HorizontalPager(
            modifier = Modifier.fillMaxWidth(),
            /* pageSize = object : PageSize {
                 override fun Density.calculateMainAxisPageSize(
                     availableSpace: Int,
                     pageSpacing: Int
                 ): Int {
                     return ((availableSpace - 2 * pageSpacing) * 0.5f).toInt()
                 }
             },*/
            state = pagerState,
            contentPadding = PaddingValues(horizontal = 20.dp), pageSpacing = 10.dp
        ) { page ->

            DisplayHorizontalPagerContent(page)
            LaunchedEffect(pagerState) {
                snapshotFlow { pagerState.currentPage }
                    .collect { currentPage ->
                        pagerState.animateScrollToPage(currentPage)
                    }
            }
        }

        Box(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(top = 20.dp, bottom = 10.dp)
        ) {
            HorizontalPagerIndicator(
                pageCount = contentList.size,
                pagerState = pagerState,
                modifier = Modifier
                    .align(Alignment.Center)
                    .clickable {
                        val currentPage = pagerState.currentPage
                        val totalPages = contentList.size
                        val nextPage =
                            if (currentPage < totalPages - 1) currentPage + 1 else 0
                        coroutineScope.launch { pagerState.animateScrollToPage(nextPage) }
                    },
                activeColor = MaterialTheme.colors.primary,
                inactiveColor = MaterialTheme.colors.background
            )
        }
    }
}


@Composable
fun DisplayHorizontalPagerContent(pageNo: Int) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(160.dp),
        contentAlignment = Alignment.Center,
    ) {

        Image(
            modifier = Modifier.clip(RoundedCornerShape(16.dp)),
            painter = painterResource(id = contentList[pageNo].imageUrl),
            contentDescription = contentList[pageNo].caption,
            contentScale = ContentScale.Fit
        )
        /*ImageFromURLWithPlaceHolder("https://picsum.photos/seed/picsum/200/300")*/
        Text(
            text = contentList[pageNo].caption,
            color = Color.White,
            fontSize = 12.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .align(Alignment.TopEnd)
                .padding(8.dp)
                .padding(horizontal = 4.dp, vertical = 2.dp)
        )
    }

}


@Composable
fun ImageFromURLWithPlaceHolder(imageUrl: String) {
    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(imageUrl)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_splash_bitcoin),
        contentDescription = stringResource(R.string.app_name),
        contentScale = ContentScale.Fit,
        modifier = Modifier.fillMaxSize()
    )
}

@OptIn(ExperimentalFoundationApi::class)
@Preview
@Composable
fun PreviewHorizontalPagerDemo() {
    MaterialTheme {
        Surface {
            CoinNotificationScreen()
        }
    }
}