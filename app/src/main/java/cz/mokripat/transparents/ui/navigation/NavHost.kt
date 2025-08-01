package cz.mokripat.transparents.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import cz.mokripat.transparents.ui.screens.detail.AccountDetailScreen
import cz.mokripat.transparents.ui.screens.list.AccountListScreen
import cz.mokripat.transparents.ui.screens.home.HomeScreen

/**
 * Navigation host managing navigation and arguments between screens.
 */
@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) {
            HomeScreen(
                onShowAccounts = {
                    navController.navigate(Screen.List.route)
                }
            )
        }

        composable(Screen.List.route) {
            AccountListScreen(
                navController = navController,
                onShowDetail = { iban ->
                    navController.navigate(Screen.Detail.createRoute(iban))
                }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("iban") { type = NavType.StringType })
        ) { backStackEntry ->
            val iban = backStackEntry.arguments?.getString("iban")
            requireNotNull(iban) { "iban must not be null" }
            AccountDetailScreen(iban = iban, navController = navController)
        }
    }
}