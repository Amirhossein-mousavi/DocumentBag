package ir.reversedev.documentbag.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.Edit
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.reversedev.documentbag.ui.theme.selectedBottomBar
import ir.reversedev.documentbag.ui.theme.unSelectedBottomBar

@Composable
fun BottomNavigationBar(
    navController: NavHostController,
    modifier: Modifier = Modifier,
    onItemClick: (BottomNavItem) -> Unit
) {
    val items = listOf(
        BottomNavItem(
            name = "home",
            route = Screen.Home.route,
            selectedIcon = Icons.Filled.Home,
            deSelectedIcon = Icons.Outlined.Home
        ),
        BottomNavItem(
            name = "note",
            route = Screen.Note.route,
            selectedIcon = Icons.Filled.Edit,
            deSelectedIcon = Icons.Outlined.Edit
        ),
        BottomNavItem(
            name = "setting",
            route = Screen.Setting.route,
            selectedIcon = Icons.Filled.Settings,
            deSelectedIcon = Icons.Outlined.Settings
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map {
        it.route
    }

    if (showBottomBar) {
        BottomNavigation(
            modifier = modifier.fillMaxWidth(),
            elevation = 5.dp,
            backgroundColor = Color.White
        ) {
            items.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colorScheme.selectedBottomBar,
                    unselectedContentColor = MaterialTheme.colorScheme.unSelectedBottomBar,

                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            if (selected) {
                                Icon(
                                    imageVector = item.selectedIcon,
                                    contentDescription = null,
                                    modifier = Modifier.height(24.dp),
                                    tint = MaterialTheme.colorScheme.selectedBottomBar
                                )
                                Text(
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 5.dp),
                                    color = MaterialTheme.colorScheme.selectedBottomBar
                                )
                            } else {
                                Icon(
                                    imageVector = item.deSelectedIcon,
                                    contentDescription = null,
                                    modifier = Modifier.height(24.dp),
                                    tint = MaterialTheme.colorScheme.unSelectedBottomBar
                                )
                                Text(
                                    text = item.name,
                                    textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.titleSmall,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.padding(top = 5.dp),
                                    color = MaterialTheme.colorScheme.unSelectedBottomBar
                                )
                            }
                        }
                    }
                )
            }
        }
    }
}