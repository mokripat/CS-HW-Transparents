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
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import cz.mokripat.transparents.R
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
                title = { Text(stringResource(R.string.account_detail_title)) },
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
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_name), value = data.name) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_number), value = data.accountNumber) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_code), value = data.bankCode) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_iban), value = data.iban) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_currency), value = data.currency ?: stringResource(R.string.unknown_value)) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_balance), value = data.balance.toString()) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_transp_from), value = data.transparencyFrom) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_transp_to), value = data.transparencyTo) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_pub_to), value = data.publicationTo) }
                item { AccountDetailField(label = stringResource(R.string.account_detail_field_act_date), value = data.actualizationDate) }
                data.description?.let {
                    item { AccountDetailField(label = stringResource(R.string.account_detail_field_description), value = it) }
                }
                item { Spacer(modifier = Modifier.height(Dim.spacingMedium)) }
            }
        }
    }
}