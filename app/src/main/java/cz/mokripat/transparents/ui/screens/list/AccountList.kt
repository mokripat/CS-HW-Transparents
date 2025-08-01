package cz.mokripat.transparents.ui.screens.list

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.tooling.preview.Preview
import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.model.PagedList
import cz.mokripat.transparents.ui.theme.TransparentsTheme


@Composable
fun AccountList(
    contentPadding: PaddingValues,
    pagedList: PagedList<Account>,
    nestedScrollConnection: NestedScrollConnection? ,
    onTryAgain: () -> Unit,
    onLoadMore: () -> Unit,
    onShowDetail: (String) -> Unit,
) {
    LazyColumn(
        contentPadding = contentPadding,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()
            .then(nestedScrollConnection?.let { Modifier.nestedScroll(it) } ?: Modifier),
    ) {
        items(pagedList.items) { account ->
            AccountCard(account) { onShowDetail(account.iban) }
        }

        item {
            when {
                pagedList.isNextLoading -> CircularProgressIndicator()
                pagedList.error != null -> ListErrorView(onTryAgain)
                pagedList.hasNextPage -> Button(onClick = onLoadMore) {
                    Text("Load more")
                }
            }
        }
    }
}

@Preview
@Composable
fun AccountListPreview() {
    TransparentsTheme {
        AccountList(
            contentPadding = PaddingValues(),
            pagedList = PagedList(
                items = listOf(
                    Account(
                        accountNumber = "000000-2192739123",
                        bankCode = "0800",
                        transparencyFrom = "2015-06-09T00:0",
                        transparencyTo = "3000-01-01T00:00:00",
                        publicationTo = "3000-01-01T00:00:00",
                        actualizationDate = "213233T",
                        balance = 720653.2,
                        currency = "CZK",
                        name = "Kristýna Zaklová",
                        iban = "CZ45 0800 0000 0021 9273 9123"
                    ),
                    Account(
                        accountNumber = "000000-2192739123",
                        bankCode = "0800",
                        transparencyFrom = "2015-06-09T00:0",
                        transparencyTo = "3000-01-01T00:00:00",
                        publicationTo = "3000-01-01T00:00:00",
                        actualizationDate = "213233T",
                        balance = 720653.2,
                        currency = "CZK",
                        name = "Kristýna Zaklová",
                        iban = "CZ45 0800 0000 0021 9273 9123"
                    ),
                    Account(
                        accountNumber = "000000-2192739123",
                        bankCode = "0800",
                        transparencyFrom = "2015-06-09T00:0",
                        transparencyTo = "3000-01-01T00:00:00",
                        publicationTo = "3000-01-01T00:00:00",
                        actualizationDate = "213233T",
                        balance = 720653.2,
                        currency = "CZK",
                        name = "Kristýna Zaklová",
                        iban = "CZ45 0800 0000 0021 9273 9123"
                    ),
                    Account(
                        accountNumber = "000000-2192739123",
                        bankCode = "0800",
                        transparencyFrom = "2015-06-09T00:0",
                        transparencyTo = "3000-01-01T00:00:00",
                        publicationTo = "3000-01-01T00:00:00",
                        actualizationDate = "213233T",
                        balance = 720653.2,
                        currency = "CZK",
                        name = "Kristýna Zaklová",
                        iban = "CZ45 0800 0000 0021 9273 9123"
                    ),
                    Account(
                        accountNumber = "000000-2192739123",
                        bankCode = "0800",
                        transparencyFrom = "2015-06-09T00:0",
                        transparencyTo = "3000-01-01T00:00:00",
                        publicationTo = "3000-01-01T00:00:00",
                        actualizationDate = "213233T",
                        balance = 720653.2,
                        currency = "CZK",
                        name = "Kristýna Zaklová",
                        iban = "CZ45 0800 0000 0021 9273 9123"
                    ),
                    Account(
                        accountNumber = "000000-2192739123",
                        bankCode = "0800",
                        transparencyFrom = "2015-06-09T00:0",
                        transparencyTo = "3000-01-01T00:00:00",
                        publicationTo = "3000-01-01T00:00:00",
                        actualizationDate = "213233T",
                        balance = 720653.2,
                        currency = "CZK",
                        name = "Kristýna Zaklová",
                        iban = "CZ45 0800 0000 0021 9273 9123"
                    ),
                ),
                isLoading = false,
                isNextLoading = false,
                error = null,
            ),
            nestedScrollConnection = null,
            onTryAgain = {},
            onLoadMore = {},
            onShowDetail = {},

        )
    }
}