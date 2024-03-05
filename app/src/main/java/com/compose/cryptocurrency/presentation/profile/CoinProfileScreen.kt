@file:OptIn(ExperimentalMaterial3Api::class)

package com.compose.cryptocurrency.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.AlertDialog
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.RadioButtonDefaults
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.compose.cryptocurrency.BuildConfig
import com.compose.cryptocurrency.R
import com.compose.cryptocurrency.presentation.Screen
import com.compose.cryptocurrency.presentation.wallet.WalletScreen

@ExperimentalMaterialApi
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CoinProfileScreen(
    viewModel: ProfileViewModel,
    navController: NavHostController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.TopCenter)
            .verticalScroll(rememberScrollState())
    ) {

        ProfileScreenCard()
        NotificationOptionUI(viewModel = viewModel)
        MoreOptionsUI(navController)
        //Profile(viewModel=viewModel ,navController)
    }
}


@ExperimentalMaterial3Api
@Composable
fun ProfileScreenCard() {
    Card(
        modifier = Modifier
            .height(150.dp)
            .padding(10.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(6.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colors.onPrimary),
        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
    ) {
        Row(
            modifier = Modifier
                .padding(20.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column {
                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color.White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = stringResource(id = R.string.app_name),
                    color = Color.White,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.SemiBold,
                )

                Button(
                    modifier = Modifier.padding(top = 10.dp),
                    onClick = {},
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colors.primary,
                        disabledContainerColor = MaterialTheme.colors.primary
                    ),
                    contentPadding = PaddingValues(horizontal = 30.dp),
                ) {
                    Text(
                        text = "version-${BuildConfig.VERSION_NAME}",
                        color = Color.White,
                        fontSize = 12.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

            Box(
                modifier = Modifier
                    .height(90.dp)
                    .width(90.dp)
                    .clip(CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_splash_bitcoin),
                    contentDescription = null,
                    modifier = Modifier.size(110.dp)
                )
            }
        }
    }
}


@ExperimentalMaterial3Api
@Composable
fun NotificationOptionUI(viewModel: ProfileViewModel) {

    val themeValue = when (viewModel.themeState.value) {
        false -> "Light Theme"
        true -> "Dark Theme"
        else -> {
            ""
        }
    }
    val themeDialog = remember { mutableStateOf(false) }
    val radioOptions = listOf("Light Theme", "Dark Theme")
    val (selectedOption, onOptionSelected) = remember { mutableStateOf(themeValue) }

    Column(
        modifier = Modifier
            .padding(horizontal = 14.dp)
           /* .padding(top = 10.dp)*/
    ) {
        Text(
            text = stringResource(id = R.string.app_theme),
            color = MaterialTheme.colors.primary,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(vertical = 8.dp)
        )
        MoreItem(icon = R.drawable.ic_dark_mode,
            mainText = stringResource(id = R.string.app_theme),
            subText = themeValue,
            onClick = { themeDialog.value = true })
    }

    if (themeDialog.value) {
        AlertDialog(
            backgroundColor = MaterialTheme.colors.primary,
            onDismissRequest = {
                themeDialog.value = false
            }, title = {
                Text(
                    text = stringResource(id = R.string.change_theme),
                    color = MaterialTheme.colors.onSurface,
                )
            }, text = {
                Column(
                    modifier = Modifier.selectableGroup(),
                    verticalArrangement = Arrangement.Center,
                ) {
                    radioOptions.forEach { text ->
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(46.dp)
                                .selectable(
                                    selected = (text == selectedOption),
                                    onClick = { onOptionSelected(text) },
                                    role = Role.RadioButton,
                                ),
                            verticalAlignment = Alignment.CenterVertically,
                        ) {
                            RadioButton(
                                selected = (text == selectedOption),
                                onClick = null,
                                colors = RadioButtonDefaults.colors(
                                    selectedColor = MaterialTheme.colors.onPrimary,
                                    unselectedColor = MaterialTheme.colors.background,
                                    disabledColor = Color.Black
                                ),
                            )
                            Text(
                                text = text,
                                modifier = Modifier.padding(start = 16.dp),
                                color = MaterialTheme.colors.onSurface,
                            )
                        }
                    }
                }
            }, confirmButton = {
                TextButton(onClick = {
                    themeDialog.value = false

                    when (selectedOption) {
                        "Light Theme" -> {
                            viewModel.updateTheme(false)
                        }

                        "Dark Theme" -> {
                            viewModel.updateTheme(true)
                        }
                    }
                }) {
                    Text(stringResource(id = R.string.confirm), color = Color.White)
                }
            }, dismissButton = {
                TextButton(onClick = {
                }) {
                    Text(stringResource(id = R.string.cancel), color = Color.White)
                }
            })
    }
}


@ExperimentalMaterialApi
@ExperimentalMaterial3Api
@Composable
fun MoreOptionsUI(navController: NavController) {
    Box {
        Column(
            modifier = Modifier
                .padding(horizontal = 14.dp)
                .padding(top = 10.dp)
        ) {


            var showSheet by remember { mutableStateOf(false) }

            if (showSheet) {
                /*BottomSheet() {
                    showSheet = false
                }*/
                showSheet = false
                navController.navigate(Screen.WalletScreen.route)
            }

            /*Text(
                text = stringResource(id = R.string.more),
                color = MaterialTheme.colors.onBackground,
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(vertical = 8.dp)
            )*/
            MoreItem(icon = R.drawable.ic_wallet,
                mainText = stringResource(id = R.string.wallet),
                subText = stringResource(id = R.string.wallet),
                onClick = {
                    showSheet = true
                })
            MoreItem(
                icon = R.drawable.ic_about_us,
                mainText = stringResource(id = R.string.about_us),
                subText = stringResource(id = R.string.about_us),
                onClick = { }
            )
            MoreItem(
                icon = R.drawable.ic_privacy_policy,
                mainText = stringResource(id = R.string.privacy_policy),
                subText = stringResource(id = R.string.privacy_policy),
                onClick = { }
            )
            MoreItem(
                icon = R.drawable.ic_terms_conditions,
                mainText = stringResource(id = R.string.terms_conditions),
                subText = stringResource(id = R.string.terms_conditions),
                onClick = { }
            )

        }
    }

}


@ExperimentalMaterial3Api
@Composable
fun MoreItem(icon: Int, mainText: String, subText: String, onClick: () -> Unit) {
    Card(
        onClick = { onClick() },
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colors.onPrimary,
        ),
        modifier = Modifier
            .padding(bottom = 8.dp)
            .fillMaxWidth()
            .height(69.dp),
    ) {
        Row(
            modifier = Modifier
                .padding(vertical = 10.dp, horizontal = 14.dp)
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colors.primary)
                ) {
                    Icon(
                        painter = painterResource(id = icon),
                        contentDescription = "",
                        tint = Color.Unspecified,
                        modifier = Modifier.padding(8.dp)
                    )
                }

                Spacer(modifier = Modifier.width(14.dp))
                Column(
                    modifier = Modifier.offset(y = (2).dp)
                ) {
                    Text(
                        text = mainText,
                        color = MaterialTheme.colors.onSurface,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Bold,
                    )

                    Spacer(modifier = Modifier.height(2.dp))

                    Text(
                        text = subText,
                        color = Color.White,
                        fontSize = 13.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier.offset(y = (-4).dp)
                    )
                }
            }
            Icon(
                painter = painterResource(id = R.drawable.ic_right_arrow),
                /*imageVector = Icons.Default.ArrowForward,*/
                contentDescription = "",
                modifier = Modifier.size(15.dp),
                tint = MaterialTheme.colors.onSurface
            )

        }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(onDismiss: () -> Unit) {
    val modalBottomSheetState = rememberModalBottomSheetState()

    ModalBottomSheet(
        onDismissRequest = { onDismiss() },
        sheetState = modalBottomSheetState,
        dragHandle = { BottomSheetDefaults.DragHandle() },
    ) {
        CountryList()
    }
}


@Composable
fun CountryList() {
    val countries = listOf(
        Pair("United States", "\uD83C\uDDFA\uD83C\uDDF8"),
        Pair("Canada", "\uD83C\uDDE8\uD83C\uDDE6"),
        Pair("India", "\uD83C\uDDEE\uD83C\uDDF3"),
        Pair("Germany", "\uD83C\uDDE9\uD83C\uDDEA"),
        Pair("France", "\uD83C\uDDEB\uD83C\uDDF7"),
        Pair("Japan", "\uD83C\uDDEF\uD83C\uDDF5"),
        Pair("China", "\uD83C\uDDE8\uD83C\uDDF3"),
        Pair("Brazil", "\uD83C\uDDE7\uD83C\uDDF7"),
        Pair("Australia", "\uD83C\uDDE6\uD83C\uDDFA"),
        Pair("Russia", "\uD83C\uDDF7\uD83C\uDDFA"),
        Pair("United Kingdom", "\uD83C\uDDEC\uD83C\uDDE7"),
    )

    LazyColumn {
        items(countries) { (country, flag) ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 10.dp, horizontal = 20.dp)
            ) {
                Text(
                    text = flag,
                    modifier = Modifier.padding(end = 20.dp)
                )
                Text(text = country)
            }
        }
    }
}