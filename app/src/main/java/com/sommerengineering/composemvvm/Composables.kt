package com.sommerengineering.composemvvm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(viewModel: UserViewModel = hiltViewModel()) {

    val users = viewModel.users.value

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("User list")})
        }) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)) {

            users.forEach {
                UserCard(it)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun UserCard(user: User) {
    Card(
        modifier = Modifier.padding(16.dp)) {

        Text(text = "Name: ${user.name}", style = MaterialTheme.typography.displayLarge)
        Text(text ="Email: ${user.email}", style = MaterialTheme.typography.displaySmall)
    }
}