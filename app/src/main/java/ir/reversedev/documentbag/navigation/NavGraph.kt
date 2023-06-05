package ir.reversedev.documentbag.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import ir.reversedev.documentbag.ui.screen.SplashScreen
import ir.reversedev.documentbag.ui.screen.home.HomeScreen
import ir.reversedev.documentbag.ui.screen.setting.SettingScreen

@Composable
fun SetupNavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Splash.route) {

        composable(Screen.Splash.route) {
            SplashScreen(navController = navController)
        }

        composable(Screen.Home.route) {
            HomeScreen(navController = navController)
        }

        composable(Screen.Note.route) {}

        composable(Screen.Setting.route) {
            SettingScreen(navController = navController)
        }

        composable(Screen.Card.route) {}
    }
}