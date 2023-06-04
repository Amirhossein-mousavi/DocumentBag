package ir.reversedev.documentbag.ui.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import ir.reversedev.documentbag.utils.Constants.USER_LANGUAGE
import ir.reversedev.documentbag.viewmodel.DataStoreViewModel

/**
 * with this composable function we can change user language in application
 */
@Composable
fun AppConfig(
    dataStore: DataStoreViewModel = hiltViewModel()
) {
    getDataStoreVariable(dataStore)


}

private fun getDataStoreVariable(dataStore: DataStoreViewModel) {
    USER_LANGUAGE = dataStore.getUserLanguage()
}