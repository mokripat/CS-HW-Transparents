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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
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
            "Account with IBAN\n${iban}\ncould not be retrieved.",
            style = MaterialTheme.typography.headlineSmall,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(Dim.spacingMedium))

        Button(onClick = onTryAgain) {
            Text("Try again")
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