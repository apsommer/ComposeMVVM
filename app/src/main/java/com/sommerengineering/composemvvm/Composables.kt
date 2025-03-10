package com.sommerengineering.composemvvm

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(viewModel: UserViewModel = hiltViewModel()) {

    val users = viewModel.users.value
    val isLoading = viewModel.isLoading.value

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(title = { Text("User list")})
        }) { padding ->

        Column(
            // verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)) {

            if (isLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .width(64.dp),
                    color = MaterialTheme.colorScheme.secondary,
                    trackColor = MaterialTheme.colorScheme.surfaceVariant,)
            }

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
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)) {

        Text(
            text = "Name: ${user.name}",
            style = MaterialTheme.typography.titleMedium,
            modifier = Modifier
                .padding(8.dp))
        Text(
            text ="Email: ${user.email}",
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier
                .padding(8.dp))
    }
}