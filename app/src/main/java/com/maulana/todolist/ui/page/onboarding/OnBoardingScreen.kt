package com.maulana.todolist.ui.page.onboarding

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.maulana.todolist.ui.component.MainButton
import com.maulana.todolist.ui.component.Spacer
import com.maulana.todolist.ui.destinations.LoginDestination
import com.maulana.todolist.ui.destinations.RegisterDestination
import com.maulana.util.GlobalDimension

@Composable
fun OnboardingScreen(navHostController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(GlobalDimension.mainPadding)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.4f),
            verticalArrangement = Arrangement.Center
        ) {
            Text("ToDo List App", fontSize = 57.sp, overflow = TextOverflow.Ellipsis)
        }
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            MainButton("Sign in") { navHostController.navigate(LoginDestination.route) }
            Spacer(24.dp)
            Text(
                "Create an account",
                fontSize = GlobalDimension.defaultFontSize,
                modifier = Modifier.clickable {
                    navHostController.navigate(RegisterDestination.route)
                })
        }

    }
}

@Preview(showSystemUi = true)
@Composable
fun Preview() {
    OnboardingScreen(rememberNavController())
}