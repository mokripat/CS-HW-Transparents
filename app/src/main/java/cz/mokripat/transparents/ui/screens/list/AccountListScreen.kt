package cz.mokripat.transparents.ui.screens.list

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
    val pagedList by viewModel.pagedAccounts.collectAsState()

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
        LazyColumn(contentPadding = innerPadding) {
            items(pagedList.items) { account ->
                Text("Account: ${account.iban}")
            }

            item {
                when {
                    pagedList.isLoading -> CircularProgressIndicator()
                    pagedList.error != null -> Text("Error: ${pagedList.error!!.message}")
                    pagedList.hasNextPage -> Button(onClick = { viewModel.loadNextPage() }) {
                        Text("Load more")
                    }
                }
            }
        }
    }
}

// TODO Preview