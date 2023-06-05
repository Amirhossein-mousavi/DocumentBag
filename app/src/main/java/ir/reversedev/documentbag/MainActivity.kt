package ir.reversedev.documentbag

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import ir.reversedev.documentbag.navigation.BottomNavigationBar
import ir.reversedev.documentbag.navigation.SetupNavGraph
import ir.reversedev.documentbag.ui.components.AppConfig
import ir.reversedev.documentbag.ui.components.MyAppTheme
import ir.reversedev.documentbag.utils.Constants.PERSIAN_LANG
import ir.reversedev.documentbag.utils.Constants.USER_LANGUAGE
import ir.reversedev.documentbag.utils.LocaleUtils
import ir.reversedev.documentbag.viewmodel.DataStoreViewModel

@AndroidEntryPoint
class MainActivity() : ComponentActivity() {

    private lateinit var navController: NavHostController

    private val dataStoreViewModel: DataStoreViewModel by viewModels()
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val isDarkTheme = remember {
                mutableStateOf(dataStoreViewModel.isSystemDark())
            }
            MyAppTheme(
                isDarkTheme =
                if (!dataStoreViewModel.themeIsDefault()) isDarkTheme.value else isSystemInDarkTheme()
            ) {
                // set value for navController
                navController = rememberNavController()
                // region set default application language and direction
                AppConfig()
                // region set direction for application views
                val direction =
                    if (USER_LANGUAGE == PERSIAN_LANG) LayoutDirection.Rtl
                    else LayoutDirection.Ltr
                // endregion set direction for application views
                // set locale for application
                LocaleUtils.setLocale(LocalContext.current, USER_LANGUAGE)
                // endregion set default application language and direction

                CompositionLocalProvider(LocalLayoutDirection provides direction) {
                    Scaffold(
                        bottomBar = {
                            BottomNavigationBar(navController = navController) {
                                navController.navigate(it.route)
                            }
                        }
                    ) {
                        SetupNavGraph(navController = navController)

                    }
                }
            }
        }
    }
}