package com.compose.cryptocurrency.presentation.wallet

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.compose.cryptocurrency.R


@Composable
fun WalletScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {


            Card(
                modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(containerColor = /*Color.White*/ MaterialTheme.colors.background),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Total Balance",
                        fontSize = 17.sp,
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$ 34.279",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(MaterialTheme.colors.onBackground)
                            .clickable {

                            }
                            .padding(6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wallet),
                            contentDescription = "Search",
                            tint = Color.Unspecified
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }

            }


            Card(
                modifier = Modifier
                    .width(160.dp)
                    .height(200.dp)
                    .padding(5.dp),
                shape = RoundedCornerShape(6.dp),
                colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.background),
                elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
            ) {

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = "Today Earning",
                        fontSize = 17.sp,
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        text = "$ 20.475",
                        fontSize = 24.sp,
                        fontWeight = FontWeight.Bold,
                        color = MaterialTheme.colors.primaryVariant,
                        textAlign = TextAlign.Center,
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Box(
                        modifier = Modifier
                            .size(100.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .background(MaterialTheme.colors.onBackground)
                            .clickable {}
                            .padding(6.dp),
                        contentAlignment = Alignment.Center
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_wallet),
                            contentDescription = "Search",
                            tint = Color.Unspecified
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
        MyTransactionScreen()
    }
}


@Composable
fun MyTransactionScreen() {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Box(contentAlignment = Alignment.CenterStart) {
            Text(
                text = "My Transaction",
                fontSize = 17.sp,
                color = MaterialTheme.colors.primaryVariant,
                textAlign = TextAlign.Start,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        }

        Box(contentAlignment = Alignment.CenterEnd) {
            Text(
                text = "See All",
                fontSize = 17.sp,
                color = MaterialTheme.colors.primaryVariant,
                textAlign = TextAlign.End,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Bold
            )
        }

    }

    Spacer(modifier = Modifier.height(8.dp))

    LazyColumn {
        items(count = 10) {
            MyTransactionCardItem()
        }

    }

}


@Composable

fun MyTransactionCardItem() {
    Card(
        modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()
            .height(100.dp)
            .padding(top = 10.dp, start = 16.dp, end = 16.dp),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.background),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {


        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 5.dp, end = 5.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.padding(8.dp),
                    contentAlignment = Alignment.CenterStart
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.ic_splash_bitcoin),
                        contentDescription = ""
                    )
                }

                Column(
                    modifier = Modifier.padding(4.dp),
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        text = "Withdraw USDT",
                        fontSize = 17.sp,
                        color = MaterialTheme.colors.primaryVariant,
                    )

                    Text(
                        text = "996.4557",
                        fontSize = 14.sp,
                        color = MaterialTheme.colors.primaryVariant,
                    )

                    /*Row(modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween) {
                        Text(
                            text = "996.4557",
                            fontSize = 14.sp,
                            color = MaterialTheme.colors.primaryVariant,
                        )

                        Text(text = "6.4%",
                            fontSize = 14.sp,
                            color = MaterialTheme.colors.primaryVariant,)
                    }*/
                }
            }

            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.BottomCenter
            ) {
                Text(
                    text = "6.4%",
                    fontSize = 14.sp,
                    color = MaterialTheme.colors.primaryVariant,
                )
            }

            Box(
                modifier = Modifier.padding(8.dp),
                contentAlignment = Alignment.CenterEnd
            )
            {
                Icon(
                    modifier = Modifier.size(15.dp),
                    painter = painterResource(id = R.drawable.ic_right_arrow),
                    contentDescription = "",
                    tint = MaterialTheme.colors.primaryVariant,
                )
            }
        }

    }
}