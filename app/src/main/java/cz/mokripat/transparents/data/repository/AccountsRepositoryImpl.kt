package cz.mokripat.transparents.data.repository

import cz.mokripat.transparents.data.api.AccountsApi
import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.model.PagedList
import cz.mokripat.transparents.domain.model.toDomain
import cz.mokripat.transparents.domain.repository.AccountsRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class AccountsRepositoryImpl(
    private val api: AccountsApi,
    private val apiKey: String,
) : AccountsRepository {

    private val _accounts = MutableStateFlow(PagedList<Account>())
    override val accounts: StateFlow<PagedList<Account>> = _accounts

    override fun resetPagination() {
        _accounts.value = PagedList()
    }

    override suspend fun loadNextPage() {
        val currentState = _accounts.value

        if (currentState.isLoading || !currentState.hasNextPage) return

        _accounts.value = currentState.copy(isLoading = true, error = null)

        try {
            val nextPage = currentState.currentPage + 1
            val response = api.getTransparentAccounts(apiKey, page = nextPage).toDomain()

            val newItems = currentState.items + response.accounts

            _accounts.value = PagedList(
                items = newItems,
                isLoading = false,
                error = null,
                currentPage = response.pageNumber,
                totalPages = response.pageCount
            )
        } catch (e: Exception) {
            _accounts.value = currentState.copy(isLoading = false, error = e)
        }
    }
}