package cz.mokripat.transparents.ui.screens.list

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.navigation.NavController
import cz.mokripat.transparents.ui.screens.list.viewmodel.AccountsViewModel
import cz.mokripat.transparents.ui.theme.Blue60
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AccountListScreen(
    navController: NavController,
    onShowDetail: (String) -> Unit,
    viewModel: AccountsViewModel = koinViewModel(),
) {
    val pagedList by viewModel.pagedAccounts.collectAsState()
    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()

    LaunchedEffect(Unit) {
        viewModel.refresh()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Transparent Accounts") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Back")
                    }
                },
                scrollBehavior = scrollBehavior,
                modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
                colors = TopAppBarDefaults.topAppBarColors(scrolledContainerColor = Blue60),
            )
        }
    ) { innerPadding ->
        if (pagedList.isLoading) {
            FullscreenLoading()
        }

        AnimatedVisibility(
            visible = !pagedList.isLoading,
            enter = fadeIn(),
            exit = fadeOut(),
        ) {
            AccountList(
                innerPadding,
                pagedList,
                scrollBehavior.nestedScrollConnection,
                viewModel::refresh,
                viewModel::loadNextPage,
                onShowDetail,
            )
        }
    }
}