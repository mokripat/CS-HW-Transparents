package cz.mokripat.transparents.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cz.mokripat.transparents.ui.viewmodel.AccountsViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    viewModel: AccountsViewModel = koinViewModel()
) {
    Column(
        modifier = modifier,
    ) {
        Button(onClick = { viewModel.fetchAccounts() }) {
            Text("Fetch Accounts")
        }
    }
}