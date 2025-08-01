package cz.mokripat.transparents.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cz.mokripat.transparents.R
import cz.mokripat.transparents.ui.theme.Dim
import cz.mokripat.transparents.ui.theme.TransparentsTheme

@Composable
fun HomeScreen(
    onShowAccounts: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top,
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = Dim.spacingLarge)
        ) {
            Spacer(modifier = Modifier.height(SCREEN_TOP_PADDING))

            Image(
                painter = painterResource(R.drawable.waving_hand),
                contentDescription = "Waving hand image",
                modifier = Modifier
                    .size(INTRO_IMAGE_SIZE)
                    .align(Alignment.CenterHorizontally)
            )

            Spacer(modifier = Modifier.height(Dim.spacingLarge))

            Text(
                text = stringResource(R.string.home_welcome_title),
                style = MaterialTheme.typography.displayMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(Dim.spacingSmall))

            Text(
                text = stringResource(R.string.home_author),
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(Dim.spacingXLarge))

            BulletPoint(emoji = "🔍", text = stringResource(R.string.home_bullet_first))
            BulletPoint(emoji = "📄", text = stringResource(R.string.home_bullet_second))
            BulletPoint(emoji = "📋", text = stringResource(R.string.home_bullet_third))

            Spacer(modifier = Modifier.height(Dim.spacingMedium))

            Spacer(modifier = Modifier.weight(1f))

            Button(
                onClick = onShowAccounts,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = SCREEN_BOTTOM_PADDING)
            ) {
                Text(text = stringResource(R.string.home_main_button_message))
            }
        }
    }
}

@Composable
private fun BulletPoint(emoji: String, text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = Dim.spacingXSmall)
    ) {
        Text(
            text = emoji,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
        Spacer(modifier = Modifier.size(Dim.spacingSmall))
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurface
        )
    }
}

private val INTRO_IMAGE_SIZE = 160.dp
private val SCREEN_BOTTOM_PADDING = 32.dp
private val SCREEN_TOP_PADDING = 64.dp

@Preview
@Composable
fun HomeScreenPreview() {
    TransparentsTheme {
        HomeScreen(onShowAccounts = {})
    }
}