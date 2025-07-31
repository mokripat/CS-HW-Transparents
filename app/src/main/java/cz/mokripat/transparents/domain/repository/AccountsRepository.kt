package cz.mokripat.transparents.domain.repository

import cz.mokripat.transparents.domain.model.AccountsResponse

/**
 * Repository for managing transparent accounts.
 */
interface AccountsRepository {

    suspend fun fetchAccounts(): Result<AccountsResponse>
}