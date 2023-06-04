package ir.reversedev.documentbag.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ir.reversedev.documentbag.R

/** set font value
 *
 */
val font_medium = FontFamily(
    Font(R.font.iranyekanmedium)
)

val font_bold = FontFamily(
    Font(R.font.iranyekanbold)
)

val font_standard = FontFamily(
    Font(R.font.iranyekan)
)

// Set of Material typography styles to start with

val Typography.extraBoldNumber: TextStyle
    @Composable get() = TextStyle(
        fontFamily = font_bold,
        fontWeight = FontWeight.Bold,
        fontSize = 26.sp,
    )

val Typography = Typography(
    headlineLarge = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 20.sp,
        lineHeight = 24.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 18.sp,
        lineHeight = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        lineHeight = 24.sp
    ),
    titleLarge = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 15.sp,
        lineHeight = 24.sp
    ),
    titleMedium = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp,
        lineHeight = 24.sp
    ),
    titleSmall = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Medium,
        fontSize = 12.sp,
        lineHeight = 24.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = font_medium,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp,
    ),
    bodyMedium = TextStyle(
        fontFamily = font_standard,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp,
        lineHeight = 24.sp,
    ),
)