package ir.reversedev.documentbag.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)


val ColorScheme.primaryColor: Color
    @Composable
    get() = Color(0xFF7A3DB4)
val ColorScheme.primaryVariantColor: Color
    @Composable
    get() = Color(0xFF524798)
val ColorScheme.onPrimaryColor: Color
    @Composable
    get() = Color(0xFFFFFFFF)

val ColorScheme.selectedBottomBar: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFF43474C) else Color(0xFF575A5E)
val ColorScheme.unSelectedBottomBar: Color
    @Composable
    get() = if (isSystemInDarkTheme()) Color(0xFFA4A1A1) else Color(0xFF85878A)

val ColorScheme.bgCard: Color
    @Composable get() = if (isSystemInDarkTheme()) Color(0xFF303030) else Color(0xFFFCFCFC)
val ColorScheme.textColor: Color
    @Composable get() = if (isSystemInDarkTheme()) Color(0xFFFCFCFC) else Color(0xFF303030)