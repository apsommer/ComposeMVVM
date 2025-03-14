package com.sommerengineering.composemvvm

import javax.inject.Inject

data class User(
    val id: Int,
    val name: String,
    val email: String
)


class UserRepository @Inject constructor() {

    // simulate network call
    fun getUsers() : List<User> {
        return listOf(
            User(1, "John Doe", "john@example.com"),
            User(2, "Jane Smith", "jane@example.com"),
            User(3, "Sam Wilson", "sam@example.com")
        )
    }
}