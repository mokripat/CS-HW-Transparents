package cz.mokripat.transparents.domain.usecase

import cz.mokripat.transparents.domain.repository.AccountsRepository

/**
 * Use case to refresh the paged list of accounts.
 */
class RefreshAccounts(private val repository: AccountsRepository) {
    suspend operator fun invoke() {
        repository.refresh()
    }
}