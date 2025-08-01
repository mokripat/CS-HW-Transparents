package cz.mokripat.transparents.ui.screens.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import cz.mokripat.transparents.R
import cz.mokripat.transparents.ui.theme.Dim
import cz.mokripat.transparents.ui.theme.TransparentsTheme

@Composable
fun ListErrorView(
    onRetry: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.padding(vertical = Dim.spacingSmall)
    ) {
        Text(stringResource(R.string.account_list_error_message))
        Button(onClick = onRetry) {
            Text(stringResource(R.string.account_list_try_again_button_text))
        }
    }
}

@Preview
@Composable
fun ListErrorViewPreview() {
    TransparentsTheme {
        ListErrorView(onRetry = {})
    }
}