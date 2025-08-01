package cz.mokripat.transparents.data.api

import cz.mokripat.transparents.data.dto.AccountsResponseDto
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

/**
 * Retrofit API interface for transparent accounts.
 */
interface AccountsApi {

    @GET("api/csas/public/sandbox/v3/transparentAccounts")
    suspend fun getTransparentAccounts(
        @Header("WEB-API-key") apiKey: String,
        @Query("size") size: Int = 25,
        @Query("page") page: Int = 0,
    ): AccountsResponseDto
}