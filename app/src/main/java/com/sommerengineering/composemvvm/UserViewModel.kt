package com.sommerengineering.composemvvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor (
    private val repository: UserRepository
) : ViewModel() {

    // protect mutable list from UI layer
    private val _users = mutableStateOf<List<User>>(emptyList())
    val users: State<List<User>> = _users

    // track network latency and loading state
    private val _isLoading = mutableStateOf(false)
    val isLoading: State<Boolean> = _isLoading

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch() {
            _isLoading.value = true
            try {
                delay(3000) // mimic network latency
                _users.value = repository.getUsers()
            } catch (e: Exception) {
                // handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
}