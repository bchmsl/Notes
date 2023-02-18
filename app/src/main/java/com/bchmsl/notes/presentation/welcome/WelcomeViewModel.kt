package com.bchmsl.notes.presentation.welcome

import androidx.lifecycle.ViewModel
import com.bchmsl.notes.common.extensions.async
import com.bchmsl.notes.domain.repository.UsernameRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import javax.inject.Inject

@HiltViewModel
class WelcomeViewModel @Inject constructor(
    private val usernameRepository: UsernameRepository
) : ViewModel() {

    private val _usernameState = MutableSharedFlow<String?>()
    val usernameState = _usernameState.asSharedFlow()

    fun getUsername() {
        async(IO) {
            _usernameState.emit(usernameRepository.getUsername())
        }
    }

    fun saveUsername(username: String) {
        async(IO) {
            usernameRepository.saveUsername(username)
        }
    }

}