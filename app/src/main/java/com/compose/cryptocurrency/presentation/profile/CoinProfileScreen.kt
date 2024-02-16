package com.compose.cryptocurrency.presentation.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ModalBottomSheetLayout
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Switch
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.compose.cryptocurrency.R
import com.compose.cryptocurrency.presentation.Screen
import kotlinx.coroutines.launch

@Composable
fun CoinProfileScreen(viewModel: ProfileViewModel,
                      navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.white))
            .wrapContentSize(Alignment.Center)
    ) {
        /*Text(
            text = "My Profile Screen",
            fontWeight = FontWeight.Bold,
            color = colorResource(R.color.primary),
            modifier = Modifier.align(Alignment.CenterHorizontally),
            textAlign = TextAlign.Center,
            fontSize = 20.sp
        )*/
        Profile(viewModel=viewModel ,navController)
    }
}


@Composable
fun Profile(
    viewModel: ProfileViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
        ) {
            /*IconButton(onClick = { navController.navigateUp() }) {
                Icon(imageVector = Icons.Outlined.ArrowBack, contentDescription = stringResource(R.string.back))
            }*/
        }
        Row(
            modifier = Modifier
                .padding(16.dp, 0.dp)
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.7f)
            ) {
                Text(
                    text = "Andrew Howard",
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                )
                Text(
                    text = "andrewhoward@gmail.com ",
                    modifier = Modifier.alpha(0.5f),
                )

            }
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.3f)
            ) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                    Image(
                        modifier = Modifier
                            .size(90.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.ic_profile),
                        contentDescription = stringResource(R.string.display_picture)
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = stringResource(R.string.edit),
                        color = MaterialTheme.colors.primary,
                        modifier = Modifier.clickable {

                        },
                        fontWeight = FontWeight.Bold
                    )
                }


            }


        }
        Divider(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            color = Color.Black
        )
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            ProfileCard(
                title = stringResource(R.string.saved_addresses),
                subtext = stringResource(R.string.add_edit_and_delete_saved_addresses),
                onClick = {

                }
            )
            ProfileCard(
                title = stringResource(R.string.payments_and_refunds),
                subtext = stringResource(R.string.information_about_refunds_and_payments),
                onClick = {
                }
            )
            ProfileCard(
                title = stringResource(R.string.online_ordering_help),
                subtext = stringResource(R.string.information_about_ordering_food),
                onClick = {
                }
            )
            ProfileCard(
                title = stringResource(R.string.about),
                subtext = stringResource(R.string.about_the_app),
                onClick = {
                },
                dividerVisibility = false
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(32.dp),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Button(
                modifier = Modifier.width(200.dp),
                onClick = {
                    viewModel.onEvent(ProfileEvent.PerformLogout {
                        /*navController.navigate(Screen.Onboarding.route) {
                            popUpTo(navController.graph.findStartDestination().id) {
                                inclusive = true
                            }
                        }*/
                    })
                }
            ) {
                Text(
                    text = stringResource(R.string.log_out),
                    fontSize = 16.sp,
                )
            }
        }
    }
}

@Composable
fun ProfileCard(
    title: String,
    subtext: String,
    onClick: () -> Unit,
    dividerVisibility: Boolean = true
) {
    Column(
        modifier = Modifier
            .padding(32.dp, 0.dp)
            .clickable {
                onClick()
            }
    ) {
        Text(
            text = title,
            fontSize = 20.sp
        )
        Text(
            text = subtext,
            modifier = Modifier.alpha(0.5f)
        )
        if (dividerVisibility) {
            Divider(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(0.dp, 8.dp)
            )
        }
        Spacer(modifier = Modifier.height(8.dp))

    }
}


@OptIn(ExperimentalMaterialApi::class, ExperimentalMaterialApi::class)
@Composable
fun ProfileScreen(
    isDarkMode: Boolean,
    onDarkModeChanged: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val scope = rememberCoroutineScope()
    ModalBottomSheetLayout(
        modifier = modifier,
        sheetContent = {
            val horizontalPaddingMod = Modifier
                .padding(horizontal = 16.dp)

            Surface(
                modifier = Modifier
                    .padding(top = 12.dp)
                    .widthIn(min = 40.dp)
                    .heightIn(min = 4.dp)
                    .align(alignment = Alignment.CenterHorizontally),
                color = Color.Gray,
                shape = RoundedCornerShape(30.dp),
            ) { }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = horizontalPaddingMod
                    .fillMaxWidth(),
            ) {
                Text(text = "Dark Mode", modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(16.dp))
                Switch(checked = isDarkMode, onCheckedChange = onDarkModeChanged)
            }
            Spacer(modifier = Modifier.height(16.dp))
        },
        sheetState = bottomSheetState,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Text(text = "johnDoe11".split("").joinToString("", limit = 10, truncated = ""))
                            Spacer(modifier = Modifier.width(4.dp))
                            Icon(imageVector = Icons.Default.KeyboardArrowDown, contentDescription = null)
                        }
                    },
                    actions = {
                        val tintIcon = MaterialTheme.colors.onBackground
                        IconButton(onClick = { /*TODO*/ }) {
                            Icon(imageVector = Icons.Default.Add, contentDescription = null, tint = tintIcon)
                        }
                        IconButton(onClick = {
                            scope.launch {
                                bottomSheetState.show()
                            }
                        }) {
                            Icon(imageVector = Icons.Default.Menu, contentDescription = null, tint = tintIcon)
                        }
                    },
                    backgroundColor = MaterialTheme.colors.background,
                    elevation = 0.dp,
                )
            }
        ) { innerPadding ->
            val innerMod = Modifier.padding(innerPadding)
            LazyColumn(
                modifier = innerMod,
            ) {
                item {
                    /*Column(modifier = Modifier.padding(top = 16.dp)) {
                        InfoUser()
                        InfoUserDescription {
                            FilledButton(
                                text = "Edit Profile",
                                modifier = Modifier.weight(1F)
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            FilledButton(
                                text = "Share Profile",
                                modifier = Modifier.weight(1F)
                            )
                        }
                    }*/
                }
            }
        }
    }
}