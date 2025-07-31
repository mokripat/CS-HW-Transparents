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
                onShowDetail = { accountId ->
                    navController.navigate(Screen.Detail.createRoute(accountId))
                }
            )
        }

        composable(
            route = Screen.Detail.route,
            arguments = listOf(navArgument("accountId") { type = NavType.StringType })
        ) { backStackEntry ->
            val accountId = backStackEntry.arguments?.getString("accountId")
            requireNotNull(accountId) { "accountId must not be null" }
            AccountDetailScreen(accountId = accountId, navController = navController)
        }
    }
}