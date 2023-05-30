package ir.reversedev.documentbag.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_screen")
    object Home : Screen("home_screen")
    object Note : Screen("note_screen")
    object Setting : Screen("setting_screen")
    object Card : Screen("card_screen")
}