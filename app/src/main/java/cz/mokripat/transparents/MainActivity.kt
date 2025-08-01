package cz.mokripat.transparents

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import cz.mokripat.transparents.di.transparentsModule
import cz.mokripat.transparents.ui.navigation.AppNavHost
import cz.mokripat.transparents.ui.theme.TransparentsTheme
import cz.mokripat.transparents.utils.networkModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        startKoin {
            androidContext(this@MainActivity)
            modules(listOf(transparentsModule, networkModule))
        }

        enableEdgeToEdge()
        setContent {
            TransparentsTheme {
                AppNavHost()
            }
        }
    }
}