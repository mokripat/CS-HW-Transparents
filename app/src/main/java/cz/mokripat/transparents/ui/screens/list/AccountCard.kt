package cz.mokripat.transparents.ui.screens.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cz.mokripat.transparents.R
import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.ui.theme.Dim
import cz.mokripat.transparents.ui.theme.TransparentsTheme

@Composable
fun AccountCard(
    account: Account,
    modifier: Modifier = Modifier,
    onShowDetail: (String) -> Unit,
) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = Dim.spacingMedium, vertical = Dim.spacingSmall),
        elevation = CardDefaults.cardElevation(defaultElevation = Dim.spacingXSmall),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface,
            contentColor = MaterialTheme.colorScheme.onSurface
        ),
        onClick = { expanded = !expanded }
    ) {
        Column(
            modifier = Modifier.padding(Dim.spacingMedium)
        ) {
            Text(
                text = account.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Text(
                text = account.iban,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )

            AnimatedVisibility(visible = expanded) {
                Row(modifier = Modifier.padding(top = Dim.spacingSmall)) {
                    Column {
                        Text(
                            text = stringResource(R.string.account_card_balance_message),
                            style = MaterialTheme.typography.bodySmall
                        )
                        Text(
                            text = stringResource(
                                R.string.account_card_balance_value,
                                account.balance,
                                account.currency ?: ""
                            ),
                            style = MaterialTheme.typography.titleMedium
                        )
                    }

                    Spacer(modifier = Modifier.weight(1f))

                    Button(
                        onClick = { onShowDetail(account.iban) },
                        shape = RoundedCornerShape(Dim.buttonRadius),
                        contentPadding = PaddingValues(
                            horizontal = Dim.spacingMedium,
                            vertical = Dim.spacingSmall
                        ),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = MaterialTheme.colorScheme.primary,
                            contentColor = MaterialTheme.colorScheme.onPrimary
                        )
                    ) {
                        Text(stringResource(R.string.account_card_button_text))
                    }

                }
            }
        }
    }
}

@Preview
@Composable
fun AccountCardPreview() {
    val account = Account(
        accountNumber = "000000-2192739123",
        bankCode = "0800",
        transparencyFrom = "2015-06-09T00:00:00",
        transparencyTo = "3000-01-01T00:00:00",
        publicationTo = "3000-01-01T00:00:00",
        actualizationDate = "2018-01-17T13:01:41",
        balance = 720653.40,
        currency = "CZK",
        name = "Kristýna Zaklová",
        iban = "CZ45 0800 0000 0021 9273 9123"
    )

    TransparentsTheme {
        AccountCard(account = account) {}
    }
}