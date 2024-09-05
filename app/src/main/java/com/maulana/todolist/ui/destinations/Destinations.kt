package com.maulana.todolist.ui.destinations


interface Destinations {
    val title: String
    val route: String
    val routeWithArgs: String
}

object HomeDestination : Destinations {
    override val title: String
        get() = "Home"

    override val route: String
        get() = "home"

    override val routeWithArgs: String
        get() = route
}

object OnBoardingDestination : Destinations {
    override val title: String
        get() = "OnBoarding"

    override val route: String
        get() = "onboarding"

    override val routeWithArgs: String
        get() = route
}

object NoteDestination : Destinations {
    override val title: String
        get() = "Notes"
    override val route: String
        get() = "notes"
    override val routeWithArgs: String
        get() = route

}

object LoginDestination : Destinations {
    override val title: String
        get() = "Login"
    override val route: String
        get() = "login"
    override val routeWithArgs: String
        get() = route
}

object RegisterDestination : Destinations {
    override val title: String
        get() = "Register"
    override val route: String
        get() = "register"
    override val routeWithArgs: String
        get() = route

}

val destinations = listOf(
    HomeDestination,
    OnBoardingDestination,
    RegisterDestination,
    LoginDestination,
    NoteDestination
)
