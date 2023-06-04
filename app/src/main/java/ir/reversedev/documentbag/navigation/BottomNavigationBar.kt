package ir.reversedev.documentbag.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import ir.reversedev.documentbag.R
import ir.reversedev.documentbag.ui.theme.primaryColor

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
            selectedIcon = painterResource(id = R.drawable.ic_home_selected),
            deSelectedIcon = painterResource(id = R.drawable.ic_home_deselected)
        ),
        BottomNavItem(
            name = "note",
            route = Screen.Note.route,
            selectedIcon = painterResource(id = R.drawable.ic_note_selected),
            deSelectedIcon = painterResource(id = R.drawable.ic_note_deselected)
        ),
        BottomNavItem(
            name = "setting",
            route = Screen.Setting.route,
            selectedIcon = painterResource(id = R.drawable.ic_setting_selected),
            deSelectedIcon = painterResource(id = R.drawable.ic_settings_deselected)
        )
    )

    val backStackEntry = navController.currentBackStackEntryAsState()
    val showBottomBar = backStackEntry.value?.destination?.route in items.map {
        it.route
    }

    if (showBottomBar) {
        BottomNavigation(modifier = modifier, elevation = 5.dp, backgroundColor = Color.White) {
            items.forEachIndexed { index, item ->
                val selected = item.route == backStackEntry.value?.destination?.route
                BottomNavigationItem(
                    selected = selected,
                    onClick = { onItemClick(item) },
                    selectedContentColor = MaterialTheme.colorScheme.primaryColor,
                    unselectedContentColor = MaterialTheme.colorScheme.primaryColor,
                    icon = {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Icon(
                                painter =
                                if (selected) item.selectedIcon else item.deSelectedIcon,
                                contentDescription = null,
                                modifier = Modifier.height(24.dp)
                            )

                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                style = MaterialTheme.typography.titleSmall,
                                fontWeight = FontWeight.Bold,
                                modifier = Modifier.padding(top = 5.dp)
                            )
                        }


                    })

            }
        }
    }
}