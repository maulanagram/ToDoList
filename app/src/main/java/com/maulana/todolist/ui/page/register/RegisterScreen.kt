package com.maulana.todolist.ui.page.register

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
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
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
import com.maulana.todolist.ui.destinations.LoginDestination
import com.maulana.todolist.ui.destinations.OnBoardingDestination
import com.maulana.util.GlobalDimension
import com.maulana.util.noRippleClickable

@Composable
fun RegisterScreen(
    navHostController: NavHostController,
    registerViewModel: RegisterViewModel = hiltViewModel()
) {
    registerViewModel.apply {
        RegisterContent(navHostController, userName.value, password.value)

        if (registerSuccess.value) {
            navHostController.navigateUp()
        }
    }
}

@Composable
fun RegisterContent(navHostController: NavHostController, userName: String, password: String) {
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
            Text("Register", fontSize = GlobalDimension.contentTitleFontSize)
            Spacer(8.dp)
            Text("Create your new account", fontSize = GlobalDimension.mainButtonFontSize)
            Spacer(40.dp)
            TextField(
                value = userName,
                placeholder = { Text("Full Name", fontSize = GlobalDimension.defaultFontSize) },
                leadingIcon = { Icon(Icons.Default.Person, "username icon") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    //userName.value = it
                })
            Spacer(20.dp)
            TextField(
                value = userName,
                placeholder = { Text("Email", fontSize = GlobalDimension.defaultFontSize) },
                leadingIcon = { Icon(Icons.Default.Email, "email icon") },
                modifier = Modifier.fillMaxWidth(),
                onValueChange = {
                    //userName.value = it
                })
            Spacer(20.dp)
            PasswordField(password, focusManager) {
                //password.value = it
            }
            Spacer(20.dp)
            MainButton("Register") { }
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

            Spacer(8.dp)
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text("Already have an account?", fontSize = GlobalDimension.defaultFontSize)
                Spacer(8.dp)
                Text(
                    "Sign in",
                    fontSize = GlobalDimension.defaultFontSize,
                    modifier = Modifier.clickable {
                        navHostController.navigate(
                            route = LoginDestination.route,
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
fun PreviewRegister() {
    RegisterContent(rememberNavController(), "", "")
}