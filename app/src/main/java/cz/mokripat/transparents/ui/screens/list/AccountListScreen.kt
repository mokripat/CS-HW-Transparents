package cz.mokripat.transparents.ui.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cz.mokripat.transparents.ui.screens.list.viewmodel.AccountsViewModel
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountListScreen(
    navController: NavController,
    onShowDetail: (String) -> Unit,
    viewModel: AccountsViewModel = koinViewModel(),
) {
    LaunchedEffect(key1 = Unit) {
        viewModel.fetchAccounts()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Transparent Accounts") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier.fillMaxSize().padding(innerPadding)
        ) {
            Text("List fetched!")

            Button(onClick = { onShowDetail("1234") }) {
                Text(text = "Show Detail")
            }
        }

    }
}

// TODO Preview