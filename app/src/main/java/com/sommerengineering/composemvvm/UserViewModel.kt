package com.sommerengineering.composemvvm

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository
) : ViewModel() {

    // protect mutable list from UI layer
    private val _users = mutableStateOf<List<User>>(emptyList())
    val users: State<List<User>> = _users

    init {
        getUsers()
    }

    private fun getUsers() {
        viewModelScope.launch {
            _users.value = repository.getUsers()
        }
    }
}