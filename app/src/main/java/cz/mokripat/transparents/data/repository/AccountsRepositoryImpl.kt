package cz.mokripat.transparents.data.repository

import cz.mokripat.transparents.data.api.AccountsApi
import cz.mokripat.transparents.domain.model.AccountsResponse
import cz.mokripat.transparents.domain.model.toDomain
import cz.mokripat.transparents.domain.repository.AccountsRepository

class AccountsRepositoryImpl(
    private val api: AccountsApi,
    private val apiKey: String,
) : AccountsRepository {

    override suspend fun fetchAccounts(): Result<AccountsResponse> {
        return try {
            val responseDto = api.getTransparentAccounts(apiKey)
            Result.success(responseDto.toDomain())
        } catch (e: Exception) {
            Result.failure(e)
        }
    }
}