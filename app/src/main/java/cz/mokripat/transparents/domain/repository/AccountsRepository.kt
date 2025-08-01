package cz.mokripat.transparents.domain.repository

import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.model.PagedList
import kotlinx.coroutines.flow.StateFlow

/**
 * Repository for fetching transparent accounts.
 */
interface AccountsRepository {

    /**
     * State flow with current accounts data represented with [PagedList].
     */
    val accounts: StateFlow<PagedList<Account>>

    /**
     * Obtains account by its IBAN.
     */
    fun getAccountByIban(iban: String): Account?

    /**
     * Invokes loading of next accounts page. Result is reflected in [accounts].
     */
    suspend fun loadNextPage()

    /**
     * Refetches fresh account data.
     */
    suspend fun refresh()
}