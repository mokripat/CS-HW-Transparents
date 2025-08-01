package cz.mokripat.transparents.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = Blue40,
    onPrimary = OnPrimary80,

    primaryContainer = Blue80,
    onPrimaryContainer = Blue40,

    secondary = BlueAccent40,
    onSecondary = OnPrimary80,

    background = LightBackground80,
    onBackground = OnBackground80,

    surface = LightSurface80,
    onSurface = OnBackground80,

    surfaceVariant = LightVariant80,
    onSurfaceVariant = OnBackground80,

    outline = Outline80,

    error = Error40,
    onError = OnPrimary80,
)

@Composable
fun TransparentsTheme(
    content: @Composable () -> Unit
) {

    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = Typography,
        content = content
    )
}