package ir.reversedev.documentbag.viewmodel

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

}