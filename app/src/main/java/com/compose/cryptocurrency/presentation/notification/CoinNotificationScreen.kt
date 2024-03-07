package com.compose.cryptocurrency.presentation.notification

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.compose.cryptocurrency.R

@Composable
fun CoinNotificationScreen() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .height(250.dp)
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


        LazyHorizontalGrid(rows = GridCells.Fixed(1)) {

            items(count = 15) {
                NotificationCardItem()
            }
        }

    }
}


@Composable

fun NotificationCardItem() {

    Card(
        modifier = Modifier
            .width(150.dp)
            .height(100.dp)
            .padding(10.dp),
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
                text = "Notification Title ", color = MaterialTheme.colors.primaryVariant,
                textAlign = TextAlign.Center
            )
            Text(
                text = "Notification Description", color = MaterialTheme.colors.primaryVariant,
                textAlign = TextAlign.Center
            )

        }
    }


}