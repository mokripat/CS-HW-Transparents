package cz.mokripat.transparents.domain.usecase

import cz.mokripat.transparents.domain.repository.AccountsRepository

/**
 * Refreshes the paged list of accounts.
 */
class RefreshAccounts(private val repository: AccountsRepository) {
    suspend operator fun invoke() {
        repository.resetPagination()
        repository.loadNextPage()
    }
}