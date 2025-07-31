package cz.mokripat.transparents.domain.usecase

import cz.mokripat.transparents.domain.repository.AccountsRepository

/**
 * Tries to load next page of accounts.
 */
class LoadNextAccountPage(private val repository: AccountsRepository) {
    suspend operator fun invoke(): Unit = repository.loadNextPage()
}