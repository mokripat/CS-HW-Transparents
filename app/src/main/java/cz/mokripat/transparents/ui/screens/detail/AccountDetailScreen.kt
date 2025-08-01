package cz.mokripat.transparents.ui.screens.detail

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import cz.mokripat.transparents.ui.screens.detail.viewModel.AccountDetailViewModel
import cz.mokripat.transparents.ui.theme.Dim
import org.koin.androidx.compose.getViewModel
import org.koin.core.parameter.parametersOf

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountDetailScreen(
    iban: String,
    navController: NavController,
) {
    val viewModel: AccountDetailViewModel = getViewModel(parameters = { parametersOf(iban) })
    val account by viewModel.account.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Account Details") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                }
            )
        }
    ) { padding ->
        if (account == null) {
            EmptyDetailScreen(iban) { viewModel.refresh() }
            return@Scaffold
        }

        LazyColumn(
            contentPadding = padding,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = Dim.spacingMedium)
        ) {
            account?.let { data ->
                item { Spacer(modifier = Modifier.height(Dim.spacingSmall)) }
                item { AccountDetailField("Name", data.name) }
                item { AccountDetailField("Account Number", data.accountNumber) }
                item { AccountDetailField("Bank Code", data.bankCode) }
                item { AccountDetailField("IBAN", data.iban) }
                item { AccountDetailField("Currency", data.currency ?: "N/A") }
                item { AccountDetailField("Balance", data.balance.toString()) }
                item { AccountDetailField("Transparency From", data.transparencyFrom) }
                item { AccountDetailField("Transparency To", data.transparencyTo) }
                item { AccountDetailField("Publication To", data.publicationTo) }
                item { AccountDetailField("Actualization Date", data.actualizationDate) }
                data.description?.let {
                    item { AccountDetailField("Description", it) }
                }
                item { Spacer(modifier = Modifier.height(Dim.spacingMedium)) }
            }
        }
    }
}