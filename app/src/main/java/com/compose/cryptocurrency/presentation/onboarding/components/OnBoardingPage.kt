package com.compose.cryptocurrency.presentation.onboarding.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.compose.cryptocurrency.R
import com.compose.cryptocurrency.presentation.Dimens.mediumPadding1
import com.compose.cryptocurrency.presentation.Dimens.mediumPadding2
import com.compose.cryptocurrency.presentation.Dimens.pageIndicatorSize
import com.compose.cryptocurrency.presentation.onboarding.PageData
import com.compose.cryptocurrency.presentation.ui.theme.CryptocurrencyAppYTTheme


@Composable
fun OnBoardingPage(modifier: Modifier, page: PageData) {

    Column {
        Image(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(0.6f),
            painter = painterResource(id = page.image),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.height(mediumPadding1))
        Text(
            modifier = Modifier.padding(horizontal = mediumPadding2),
            text = page.title,
            style = MaterialTheme.typography.body1,
            color = colorResource(id = R.color.white)
        )
        Text(
            modifier = Modifier.padding(horizontal = mediumPadding2),
            text = page.description,
            style = MaterialTheme.typography.body2,
            color = colorResource(id = R.color.white)
        )

    }

}


@Composable
fun PageIndicator(
    modifier: Modifier, pageSize: Int,
    selectedPage: Int,
    selectedColor: Color = Color.Yellow,
    unSelectedColor: Color = MaterialTheme.colors.secondaryVariant
) {

    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        repeat(times = pageSize){ page ->
            Box(
                modifier = Modifier
                    .size(pageIndicatorSize)
                    .clip(CircleShape)
                    .background(color = if(page == selectedPage) selectedColor else unSelectedColor)
            )
        }
    }
}


@Preview(showBackground = true)
@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun OnBoardingPagePreview() {
    CryptocurrencyAppYTTheme {
        OnBoardingPage(Modifier.padding(10.dp),
            page = PageData(
                title = "Lorem Ipsum is simply dummy",
                description = "Lorem Ipsum is simply dummy text of the printing and typesetting industry.",
                image = R.drawable.ic_onboarding_screen
            )
        )
    }
}



