package cz.mokripat.transparents.ui.screens.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.model.PagedList
import cz.mokripat.transparents.domain.usecase.LoadNextAccountPage
import cz.mokripat.transparents.domain.usecase.ObserveAccountsPagedList
import cz.mokripat.transparents.domain.usecase.RefreshAccounts
import cz.mokripat.transparents.ui.screens.home.HomeScreen
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

/**
 * ViewModel for the [HomeScreen].
 */
class AccountsViewModel(
    observeAccountsPagedList: ObserveAccountsPagedList,
    private val loadNextAccountPage: LoadNextAccountPage,
    private val refreshAccounts: RefreshAccounts,
) : ViewModel() {

    val pagedAccounts: StateFlow<PagedList<Account>> = observeAccountsPagedList()

    /**
     * Triggers loading of the next page of accounts.
     */
    fun loadNextPage() {
        viewModelScope.launch {
            loadNextAccountPage()
        }
    }

    /**
     * Refreshes accounts.
     */
    fun refresh() {
        viewModelScope.launch {
            refreshAccounts()
        }
    }
}
