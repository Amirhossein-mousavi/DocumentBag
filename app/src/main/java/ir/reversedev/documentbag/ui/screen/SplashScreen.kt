package ir.reversedev.documentbag.ui.screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import ir.reversedev.documentbag.R
import ir.reversedev.documentbag.navigation.Screen
import ir.reversedev.documentbag.ui.components.Loading3dots
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController) {
    Splash()
    LaunchedEffect(true) {
        delay(2000)
        navController.navigate(Screen.Home.route)
    }
}

@Composable
fun Splash() {
    Box(
        modifier = Modifier
            .background(MaterialTheme.colorScheme.primary)
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    )
    {
        Image(
            painter = painterResource(id = R.drawable.splash_image),
            contentDescription = null,
            modifier = Modifier.size(250.dp)
        )
    }
    Box(modifier = Modifier
        .fillMaxSize()
        .padding(20.dp) ,
    contentAlignment = Alignment.BottomCenter
    ) {
        Loading3dots(isDark = false)
    }
}