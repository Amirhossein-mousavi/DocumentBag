package ir.reversedev.documentbag.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.reversedev.documentbag.ui.screen.SplashScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.Home.route) {}

        composable(Screen.Note.route) {}

        composable(Screen.Setting.route) {}

        composable(Screen.Card.route) {}
    }
}