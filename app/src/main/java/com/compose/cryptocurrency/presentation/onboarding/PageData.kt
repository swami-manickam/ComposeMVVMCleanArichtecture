package com.compose.cryptocurrency.presentation.onboarding

import androidx.annotation.DrawableRes
import com.compose.cryptocurrency.R


data class PageData(val title: String, val description: String, @DrawableRes val image: Int)

val pageList = listOf(

    PageData(
        title = "Easy Exchange",
        description = "Fast and Secure way to exchange and purchase 100+ cryptocurrencies.",
        image = R.drawable.ic_onboarding_screen
    ),

    PageData(
        title = "Enhance Productivity",
        description = "The technologies in the modern tech age are adopting to enhance productivity.",
        image = R.drawable.ic_onboarding_screen
    ),
    PageData(
        title = "Transparent Community",
        description = "The individuals who are part of community help raise funds to use features of the technology",
        image = R.drawable.ic_onboarding_screen
    )


)