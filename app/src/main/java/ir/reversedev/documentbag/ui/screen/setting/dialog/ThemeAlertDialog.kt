package ir.reversedev.documentbag.ui.screen.setting.dialog

import android.app.Activity
import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.selection.selectableGroup
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import ir.reversedev.documentbag.MainActivity
import ir.reversedev.documentbag.R
import ir.reversedev.documentbag.ui.screen.setting.openThemeDialogState
import ir.reversedev.documentbag.ui.theme.onPrimaryColor
import ir.reversedev.documentbag.ui.theme.primaryColor
import ir.reversedev.documentbag.ui.theme.textColor
import ir.reversedev.documentbag.viewmodel.DataStoreViewModel


@Composable
fun ThemeAlertDialog(
    dataStoreViewModel: DataStoreViewModel,
    activity: Activity
) {
    /**
     * set radio button data
     */
    val radioOptions = listOf(
        stringResource(id = R.string.defaul),
        stringResource(id = R.string.light_theme),
        stringResource(id = R.string.dark_theme),
    )
    var selectedItem by remember {
        if (dataStoreViewModel.themeIsDefault())
            mutableStateOf(radioOptions[0])
        else if (!dataStoreViewModel.isSystemDark())
            mutableStateOf(radioOptions[1])
        else mutableStateOf(radioOptions[2])
    }

    AlertDialog(onDismissRequest = { openThemeDialogState.value = false },
        title = {
            Text(
                text = stringResource(id = R.string.application_theme),
                style = MaterialTheme.typography.headlineMedium,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.textColor
            )
        },
        icon = {
            Image(painter = painterResource(id = R.drawable.ic_theme), contentDescription = null)
        },
        text = {
            /** crete radio button groups for theming
             *
             */
            Column(modifier = Modifier.selectableGroup()) {
                radioOptions.forEach { label ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(56.dp)
                            .selectable(
                                selected = (selectedItem == label),
                                onClick = { selectedItem = label },
                                role = Role.RadioButton
                            )
                            .padding(horizontal = 16.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            modifier = Modifier.padding(end = 16.dp),
                            selected = (selectedItem == label),
                            onClick = null // null recommended for accessibility with screen readers
                        )
                        Text(text = label)
                    }
                }
            }


        },
        confirmButton = {
            Button(
                onClick = {
                    /**
                     * here we checking selected radio button for theming
                     */
                    when (selectedItem) {
                        radioOptions[0] -> {
                            dataStoreViewModel.themeIsDefault(true)
                        }

                        radioOptions[1] -> {
                            dataStoreViewModel.themeIsDefault(false)
                            dataStoreViewModel.isSystemDark(false)
                        }

                        radioOptions[2] -> {
                            dataStoreViewModel.themeIsDefault(false)
                            dataStoreViewModel.isSystemDark(true)
                        }
                    }

                    activity.apply {
                        finish()
                        startActivity(Intent(this, MainActivity::class.java))
                    }
                    openThemeDialogState.value = false

                }, colors = ButtonDefaults.buttonColors(
                    MaterialTheme.colorScheme.primaryColor, MaterialTheme.colorScheme.onPrimaryColor
                ), modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.confirm))
            }
        },
        dismissButton = {
            OutlinedButton(
                onClick = {
                    openThemeDialogState.value = false

                }, colors = ButtonDefaults.buttonColors(
                    containerColor = MaterialTheme.colorScheme.surface,
                    contentColor = MaterialTheme.colorScheme.textColor
                ), modifier = Modifier.padding(horizontal = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.cancel))
            }
        }
    )

}