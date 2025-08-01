package cz.mokripat.transparents.domain.usecase

import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.model.PagedList
import cz.mokripat.transparents.domain.repository.AccountsRepository
import kotlinx.coroutines.flow.StateFlow

/**
 * Use case to observe current paged list of accounts.
 */
class ObserveAccountsPagedList(private val repository: AccountsRepository) {
    operator fun invoke(): StateFlow<PagedList<Account>> = repository.accounts
}