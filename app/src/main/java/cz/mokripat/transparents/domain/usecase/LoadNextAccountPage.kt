package cz.mokripat.transparents.domain.usecase

import cz.mokripat.transparents.domain.repository.AccountsRepository

/**
 * Use case for to loading next page of accounts.
 */
class LoadNextAccountPage(private val repository: AccountsRepository) {
    suspend operator fun invoke(): Unit = repository.loadNextPage()
}