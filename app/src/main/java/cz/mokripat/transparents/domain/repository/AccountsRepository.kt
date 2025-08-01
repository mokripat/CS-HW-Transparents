package cz.mokripat.transparents.domain.repository

import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.model.PagedList
import kotlinx.coroutines.flow.StateFlow

/**
 * Repository for fetching transparent accounts.
 */
interface AccountsRepository {
    val accounts: StateFlow<PagedList<Account>>

    fun getAccountByIban(iban: String): Account?
    suspend fun loadNextPage()
    suspend fun refresh()
}