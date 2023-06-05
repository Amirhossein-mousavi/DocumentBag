package ir.reversedev.documentbag.ui.screen.setting

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import ir.reversedev.documentbag.MainActivity
import ir.reversedev.documentbag.R
import ir.reversedev.documentbag.ui.theme.bgCard
import ir.reversedev.documentbag.ui.theme.onPrimaryColor
import ir.reversedev.documentbag.ui.theme.primaryColor
import ir.reversedev.documentbag.ui.theme.roundedCornerShapeMedium
import ir.reversedev.documentbag.ui.theme.textColor
import ir.reversedev.documentbag.utils.Constants.ENGLISH_LANG
import ir.reversedev.documentbag.utils.Constants.PERSIAN_LANG
import ir.reversedev.documentbag.viewmodel.DataStoreViewModel

val openLanguageDialogState = mutableStateOf(false)
val openThemeDialogState = mutableStateOf(false)

@Composable
fun SettingScreen(
    navController: NavHostController,
    dataStoreViewModel: DataStoreViewModel = hiltViewModel()
) {
    val openLanguageDialog = remember {
        openLanguageDialogState
    }
    val openThemeDialog = remember {
        openThemeDialogState
    }
    val activity = LocalContext.current as Activity
    if (openLanguageDialog.value) {
        LanguageAlert(dataStoreViewModel)
    }
    if (openThemeDialog.value)
        ThemeAlertDialog(dataStoreViewModel , activity)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .height(200.dp)
            .padding(bottom = 56.dp, start = 16.dp, top = 16.dp, end = 16.dp)
    ) {

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            shape = MaterialTheme.shapes.roundedCornerShapeMedium,
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.bgCard,
                MaterialTheme.colorScheme.bgCard
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                text = stringResource(id = R.string.settings),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.textColor
            )
            SettingsViewItem(
                R.drawable.ic_language,
                stringResource(id = R.string.change_language), onClick = {
                    openLanguageDialog.value = true
                })
            SettingsViewItem(
                R.drawable.ic_theme,
                stringResource(id = R.string.application_theme)
            ) {
                openThemeDialog.value = true
            }
            SettingsViewItem(
                R.drawable.ic_lock,
                stringResource(id = R.string.security)
            ) {}
        }
        Spacer(modifier = Modifier.height(16.dp))
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 8.dp),
            shape = MaterialTheme.shapes.roundedCornerShapeMedium,
            colors = CardDefaults.cardColors(
                MaterialTheme.colorScheme.bgCard,
                MaterialTheme.colorScheme.bgCard
            ),
            elevation = CardDefaults.cardElevation(16.dp)
        ) {
            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                text = stringResource(id = R.string.info),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.textColor
            )
            SettingsViewItem(R.drawable.ic_star, stringResource(id = R.string.rate_us)) {}
            SettingsViewItem(R.drawable.ic_apps, stringResource(id = R.string.our_applications)) {}
            SettingsViewItem(R.drawable.ic_info, stringResource(id = R.string.about_us)) {}

        }


    }
}

@Composable
fun SettingsViewItem(
    @DrawableRes image: Int,
    title: String,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(horizontal = 8.dp)
            .background(MaterialTheme.colorScheme.bgCard)
            .clickable(
                onClick = { onClick() },
                interactionSource = remember {
                    MutableInteractionSource()
                },
                indication = rememberRipple(
                    bounded = true,
                    color = Color(0xFF7A3DB4)
                )
            ),
        verticalAlignment = Alignment.CenterVertically
    ) {

        Image(
            painter = painterResource(id = image),
            contentDescription = "",
            modifier = Modifier.padding(4.dp)
        )
        Text(
            text = title,
            modifier = Modifier.padding(start = 32.dp),
            color = MaterialTheme.colorScheme.textColor
        )
    }
}

@Composable
fun LanguageAlert(
    dataStoreViewModel: DataStoreViewModel
) {
    val activity = LocalContext.current as Activity
    AlertDialog(onDismissRequest = { openLanguageDialogState.value = false },
        title = {
            Text(
                text = stringResource(id = R.string.change_language),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.textColor
            )
        },
        icon = {
            Image(painter = painterResource(id = R.drawable.ic_language), contentDescription = null)
        },
        text = {
            Text(
                text = stringResource(id = R.string.select_your_language),
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.textColor
            )
        },
        confirmButton = {
            Button(
                onClick = {
                    if (dataStoreViewModel.getUserLanguage() != PERSIAN_LANG) {
                        dataStoreViewModel.saveUserLanguage(PERSIAN_LANG)
                        openLanguageDialogState.value = false
                        activity.apply {
                            finish()
                            startActivity(Intent(activity, MainActivity::class.java))
                        }
                    } else {
                        Toast.makeText(
                            activity.applicationContext,
                            "زبان فعلی اپلیکیشن فارسی است.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }, colors = ButtonDefaults.buttonColors(
                    MaterialTheme.colorScheme.primaryColor, MaterialTheme.colorScheme.onPrimaryColor
                ), modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.persian))
            }
            Button(
                onClick = {
                    if (dataStoreViewModel.getUserLanguage() != ENGLISH_LANG) {
                        dataStoreViewModel.saveUserLanguage(ENGLISH_LANG)
                        openLanguageDialogState.value = false
                        activity.apply {
                            finish()
                            startActivity(Intent(activity, MainActivity::class.java))
                        }
                    } else {
                        Toast.makeText(
                            activity.applicationContext,
                            "The current language of application is English.",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }, colors = ButtonDefaults.buttonColors(
                    MaterialTheme.colorScheme.primaryColor, MaterialTheme.colorScheme.onPrimaryColor
                ), modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.english))
            }
        },
        dismissButton = {
        })
}