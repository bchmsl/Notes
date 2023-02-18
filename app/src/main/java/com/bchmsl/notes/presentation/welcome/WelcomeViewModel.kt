package com.bchmsl.notes.presentation.welcome

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bchmsl.notes.domain.repository.UsernameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(private val usernameRepository: UsernameRepository) : ViewModel() {

    private val _usernameState = MutableSharedFlow<String?>()
    val usernameState = _usernameState.asSharedFlow()

    fun getUsername() {
        viewModelScope.launch(Dispatchers.IO) {
            _usernameState.emit(usernameRepository.getUsername())
        }
    }

    fun saveUsername(username: String){
        viewModelScope.launch(Dispatchers.IO) {
           usernameRepository.saveUsername(username)
        }
    }

}