package cz.mokripat.transparents.data.repository

import cz.mokripat.transparents.data.api.AccountsApi
import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.model.PagedList
import cz.mokripat.transparents.domain.model.toDomain
import cz.mokripat.transparents.domain.repository.AccountsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

/**
 * Implementation of [AccountsRepository] using [AccountsApi].
 *
 * Refresh includes delay to simulate network delay.
 */
class AccountsRepositoryImpl(
    private val api: AccountsApi,
    private val apiKey: String,
) : AccountsRepository {

    private val _accounts = MutableStateFlow(PagedList<Account>())
    override val accounts: StateFlow<PagedList<Account>> = _accounts

    override fun getAccountByIban(iban: String): Account? =
        _accounts.value.items.firstOrNull { account -> account.iban == iban } // Naive implementation, assuming limited number of accounts

    override suspend fun refresh() {
        _accounts.value = PagedList(isLoading = true)
        delay(2000) // Simulate network delay (wanted)
        loadNextPage()
    }

    override suspend fun loadNextPage() {
        val currentState = _accounts.value

        if (currentState.isNextLoading || !currentState.hasNextPage) return

        _accounts.value = currentState.copy(isNextLoading = true, error = null)

        try {
            val nextPage = currentState.currentPage + 1
            val response = api.getTransparentAccounts(apiKey, page = nextPage).toDomain()

            val newItems = currentState.items + response.accounts

            _accounts.value = PagedList(
                items = newItems,
                isLoading = false,
                isNextLoading = false,
                error = null,
                currentPage = response.pageNumber,
                totalPages = response.pageCount
            )
        } catch (e: Exception) {
            _accounts.value = currentState.copy(isLoading = false, isNextLoading = false, error = e)
        }
    }
}