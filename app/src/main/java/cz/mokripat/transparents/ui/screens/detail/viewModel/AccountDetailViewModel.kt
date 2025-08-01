package cz.mokripat.transparents.ui.screens.detail.viewModel

import androidx.lifecycle.ViewModel
import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.usecase.GetAccountByIban
import cz.mokripat.transparents.ui.screens.detail.AccountDetailScreen
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * View model for [AccountDetailScreen].
 */
class AccountDetailViewModel(
    private val iban: String,
    private val getAccountByIban: GetAccountByIban,
) : ViewModel() {

    private val _account: MutableStateFlow<Account?> = MutableStateFlow(getAccountByIban(iban))
    val account: StateFlow<Account?> = _account

    /**
     * Refreshes account data.
     */
    fun refresh() {
        _account.value = getAccountByIban(iban)
    }
}