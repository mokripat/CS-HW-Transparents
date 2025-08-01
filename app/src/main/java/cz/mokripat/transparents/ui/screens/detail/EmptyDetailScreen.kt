package cz.mokripat.transparents.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import cz.mokripat.transparents.R
import cz.mokripat.transparents.ui.theme.Dim
import cz.mokripat.transparents.ui.theme.TransparentsTheme

@Composable
fun EmptyDetailScreen(
    iban: String,
    modifier: Modifier = Modifier,
    onTryAgain: () -> Unit,
) {
    Column(
        modifier = modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(R.string.account_detail_empty_message, iban),
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Dim.spacingMedium))

        Button(onClick = onTryAgain) {
            Text(stringResource(R.string.account_detail_try_again_message))
        }
    }
}

@Preview
@Composable
fun EmptyDetailScreenPreview() {
    TransparentsTheme {
        EmptyDetailScreen(iban = "CZ1234567890", onTryAgain = {})
    }
}