package cz.mokripat.transparents.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object List : Screen("list")
    object Detail : Screen("account_detail/{iban}") {
        fun createRoute(iban: String) = "account_detail/$iban"
    }
}