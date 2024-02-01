package com.compose.cryptocurrency.presentation.commonview

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.TextButton
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


@Composable
fun CoinButton(modifier: Modifier,text: String, onClick: () -> Unit) {

    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(
            contentColor = MaterialTheme.colors.onPrimary,
            containerColor = MaterialTheme.colors.secondaryVariant
        ),
        shape = RoundedCornerShape(size = 6.dp)
    ) {

        Text(text = text, style = MaterialTheme.typography.body2)

    }
}


@Composable
fun CoinTextButton(modifier: Modifier,text: String, onClick: () -> Unit) {

    TextButton(modifier = modifier,onClick = onClick) {
        Text(
            text = text,
            style = MaterialTheme.typography.body2,
            color = MaterialTheme.colors.secondaryVariant
        )
    }


}

