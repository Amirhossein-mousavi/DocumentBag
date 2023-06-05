package ir.reversedev.documentbag.viewmodel

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.reversedev.documentbag.data.datastore.DataStoreRepository
import ir.reversedev.documentbag.utils.Constants.PERSIAN_LANG
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class DataStoreViewModel @Inject constructor(
    private val repository: DataStoreRepository
) : ViewModel() {

    companion object {
        const val USER_LANGUAGE_KEY = "USER_LANGUAGE_KEY"
        const val USER_THEME_KEY = "USER_THEME_KEY"
        const val THEME_IS_DEFAULT_KEY = "THEME_IS_DEFAULT_KEY"
    }

    /**
     * with this functions we can get and put user language for application
     */
    // region user language
    fun saveUserLanguage(value: String) {
        viewModelScope.launch {
            repository.putString(USER_LANGUAGE_KEY, value)
        }
    }

    fun getUserLanguage(): String = runBlocking {
        repository.getString(USER_LANGUAGE_KEY) ?: PERSIAN_LANG
    }
    // endregion user language

    /**
     * with this function we can get and put user custom theme
     */

    // region save and get user theme
    fun isSystemDark(value: Boolean) {
        viewModelScope.launch {
            repository.putBoolean(USER_THEME_KEY, value)
        }
    }

    fun themeIsDefault(value: Boolean) {
        viewModelScope.launch {
            repository.putBoolean(THEME_IS_DEFAULT_KEY, value)
        }
    }

    fun themeIsDefault(): Boolean =
        runBlocking { repository.getBoolean(THEME_IS_DEFAULT_KEY) ?: true }

    fun isSystemDark(): Boolean = runBlocking {
        repository.getBoolean(USER_THEME_KEY) ?: false
    }

    // endregion save and get user theme

}