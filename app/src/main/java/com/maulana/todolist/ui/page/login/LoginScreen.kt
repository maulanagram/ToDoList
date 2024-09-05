package com.maulana.todolist.ui.page.login

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import com.maulana.todolist.ui.component.MainButton
import com.maulana.todolist.ui.component.PasswordField
import com.maulana.todolist.ui.component.Spacer
import com.maulana.todolist.ui.destinations.NoteDestination
import com.maulana.todolist.ui.destinations.OnBoardingDestination
import com.maulana.todolist.ui.destinations.RegisterDestination
import com.maulana.util.GlobalDimension
import com.maulana.util.noRippleClickable

@Composable
fun LoginScreen(
    navHostController: NavHostController,
    loginViewModel: LoginViewModel = hiltViewModel()
) {
    loginViewModel.apply {
        LoginContent(navHostController, userName.value, password.value)

        if (loginSuccess.value) {
            navHostController.navigateUp()
        }
    }
}

@Composable
fun LoginContent(navHostController: NavHostController, userName: String, password: String) {
    val focusManager = LocalFocusManager.current

    ConstraintLayout(
        modifier = Modifier
            .fillMaxSize()
            .padding(GlobalDimension.mainPadding)
    ) {
        val (layoutTop, layoutBottom) = createRefs()

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .constrainAs(layoutTop) {
                    top.linkTo(parent.top)
                    start.linkTo(parent.start)
                    end.linkTo(parent.end)
                    bottom.linkTo(layoutBottom.top)
                    height = Dimension.fillToConstraints
                }, horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Icon(
                    Icons.AutoMirrored.Default.ArrowBack,
                    "Back Icon",
                    modifier = Modifier.noRippleClickable {
                        navHostController.navigateUp()
                    })
                Spacer(200.dp)
            }
            Text("Welcome", fontSize = GlobalDimension.contentTitleFontSize)
            Spacer(8.dp)
            Text("Login to your account", fontSize = GlobalDimension.mainButtonFontSize)
            Spacer(40.dp)
            TextField(
                value = userName,
                placeholder = { Text("Username", fontSize = GlobalDimension.defaultFontSize) },
                leadingIcon = { Icon(Icons.Default.Person, "username icon") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    //userName.value = it
                })
            Spacer(20.dp)
            PasswordField(password, focusManager) {
                //password.value = it
            }
            Spacer(8.dp)
            ConstraintLayout(modifier = Modifier.fillMaxWidth()) {
                val (left, center, right) = createRefs()

                Checkbox(
                    checked = false,
                    onCheckedChange = {},
                    modifier = Modifier.constrainAs(left) {
                        start.linkTo(parent.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    })
                Text(
                    "Remember Me",
                    fontSize = GlobalDimension.smallFontSize,
                    modifier = Modifier.constrainAs(center) {
                        start.linkTo(left.end)
                        end.linkTo(right.start)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                        width = Dimension.fillToConstraints
                    }, textAlign = TextAlign.Start
                )
                Text(
                    "Forgot Password?",
                    fontSize = GlobalDimension.smallFontSize,
                    modifier = Modifier.constrainAs(right) {
                        end.linkTo(parent.end)
                        top.linkTo(parent.top)
                        bottom.linkTo(parent.bottom)
                    })
            }
        }
        Column(modifier = Modifier
            .fillMaxWidth()
            .constrainAs(layoutBottom) {
                top.linkTo(layoutTop.bottom)
                start.linkTo(parent.start)
                end.linkTo(parent.end)
                bottom.linkTo(parent.bottom)
                height = Dimension.wrapContent
            }) {
            MainButton("Login") {
                navHostController.navigate(NoteDestination.route)
            }
            Spacer(8.dp)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text("Don't have account?", fontSize = GlobalDimension.defaultFontSize)
                Spacer(8.dp)
                Text(
                    "Sign up",
                    fontSize = GlobalDimension.defaultFontSize,
                    modifier = Modifier.clickable {
                        navHostController.navigate(
                            route = RegisterDestination.route,
                            navOptions = navOptions {
                                popUpTo(OnBoardingDestination.route)
                            }
                        )
                    })
            }
        }
    }
}

@Preview(showSystemUi = true, device = "id:pixel_8")
@Composable
fun PreviewLogin() {
    LoginContent(rememberNavController(), "", "")
}