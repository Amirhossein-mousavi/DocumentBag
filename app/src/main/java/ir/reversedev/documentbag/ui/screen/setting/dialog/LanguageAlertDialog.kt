package ir.reversedev.documentbag.ui.screen.setting.dialog

import android.app.Activity
import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.reversedev.documentbag.MainActivity
import ir.reversedev.documentbag.R
import ir.reversedev.documentbag.ui.screen.setting.openLanguageDialogState
import ir.reversedev.documentbag.ui.theme.onPrimaryColor
import ir.reversedev.documentbag.ui.theme.primaryColor
import ir.reversedev.documentbag.ui.theme.textColor
import ir.reversedev.documentbag.utils.Constants
import ir.reversedev.documentbag.viewmodel.DataStoreViewModel

@Composable
fun LanguageAlertDialog(
    dataStoreViewModel: DataStoreViewModel,
    activity: Activity
) {
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
                    if (dataStoreViewModel.getUserLanguage() != Constants.PERSIAN_LANG) {
                        dataStoreViewModel.saveUserLanguage(Constants.PERSIAN_LANG)
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
                    if (dataStoreViewModel.getUserLanguage() != Constants.ENGLISH_LANG) {
                        dataStoreViewModel.saveUserLanguage(Constants.ENGLISH_LANG)
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
        }
    )
}