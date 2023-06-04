package ir.reversedev.documentbag.navigation

import androidx.compose.ui.graphics.vector.ImageVector

data class BottomNavItem(
    val name: String,
    val route: String,
    val selectedIcon: ImageVector,
    val deSelectedIcon: ImageVector,
)
