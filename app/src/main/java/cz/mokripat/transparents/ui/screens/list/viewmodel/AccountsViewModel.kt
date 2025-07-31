package cz.mokripat.transparents.ui.screens.list.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.model.PagedList
import cz.mokripat.transparents.domain.usecase.LoadNextAccountPage
import cz.mokripat.transparents.domain.usecase.ObserveAccountsPagedList
import cz.mokripat.transparents.domain.usecase.RefreshAccounts
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AccountsViewModel(
    observeAccountsPagedList: ObserveAccountsPagedList,
    private val loadNextAccountPage: LoadNextAccountPage,
    private val refreshAccounts: RefreshAccounts,
) : ViewModel() {

    val pagedAccounts: StateFlow<PagedList<Account>> = observeAccountsPagedList()

    fun loadNextPage() {
        viewModelScope.launch {
            loadNextAccountPage()
        }
    }

    fun refresh() {
        viewModelScope.launch {
            refreshAccounts()
        }
    }
}
