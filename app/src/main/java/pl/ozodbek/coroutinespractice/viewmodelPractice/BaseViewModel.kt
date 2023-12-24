package pl.ozodbek.coroutinespractice

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

open class BaseViewModel : ViewModel() {
    protected val _uiState = MutableLiveData<UiState<Any>>()
    val uiState: LiveData<UiState<Any>> get() = _uiState

    protected fun showLoading() {
        _uiState.value = UiState.Loading
    }

    protected fun <T : Any> showSuccess(data: T) {
        _uiState.value = UiState.Success(data)
    }

    protected fun showError(message: String) {
        _uiState.value = UiState.Error(message)
    }
}