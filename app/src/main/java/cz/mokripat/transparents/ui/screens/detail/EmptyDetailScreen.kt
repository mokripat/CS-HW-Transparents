package cz.mokripat.transparents.ui.screens.detail

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cz.mokripat.transparents.ui.theme.Dim

@Composable
fun EmptyDetailScreen(
    iban: String,
    onTryAgain: () -> Unit,
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Account with IBAN")
        Text(iban)
        Text("could not be retrieved")

        Spacer(modifier = Modifier.height(Dim.spacingMedium))

        Button(onClick = onTryAgain) {
            Text("Try again")
        }
    }
}