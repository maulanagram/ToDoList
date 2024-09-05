package com.maulana.todolist

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.maulana.todolist.ui.destinations.LoginDestination
import com.maulana.todolist.ui.destinations.NoteDestination
import com.maulana.todolist.ui.destinations.OnBoardingDestination
import com.maulana.todolist.ui.destinations.RegisterDestination
import com.maulana.todolist.ui.destinations.destinations
import com.maulana.todolist.ui.page.login.LoginScreen
import com.maulana.todolist.ui.page.note.NoteScreen
import com.maulana.todolist.ui.page.onboarding.OnboardingScreen
import com.maulana.todolist.ui.page.register.RegisterScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NoteApp() {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val snackBarState = remember { SnackbarHostState() }

    val sheetState = rememberModalBottomSheetState()

    val currentScreen = destinations.find {
        backStackEntry?.destination?.route == it.route ||
                backStackEntry?.destination?.route == it.routeWithArgs
    } ?: OnBoardingDestination

    Scaffold(
        snackbarHost = { SnackbarHost(hostState = snackBarState) },
        floatingActionButton = {
            if (currentScreen.route == NoteDestination.route) {
                FloatingActionButton(onClick = {}) {
                    Icon(
                        Icons.Default.Add,
                        "add icon"
                    )
                }
            }
        }
    ) { innerPaddings ->
        NavHost(
            navController = navController,
            modifier = Modifier.padding(innerPaddings),
            startDestination = OnBoardingDestination.routeWithArgs
        ) {
            composable(OnBoardingDestination.routeWithArgs) {
                OnboardingScreen(navController)
            }
            composable(NoteDestination.routeWithArgs) {
                NoteScreen(navController)
            }
            composable(LoginDestination.routeWithArgs) {
                LoginScreen(navController)
            }
            composable(RegisterDestination.routeWithArgs) {
                RegisterScreen(navController)
            }
        }
    }
}