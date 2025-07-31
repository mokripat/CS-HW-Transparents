package cz.mokripat.transparents.data.api

import cz.mokripat.transparents.data.dto.AccountsResponseDto
import retrofit2.http.GET
import retrofit2.http.Header

interface AccountsApi {
    @GET("api/csas/public/sandbox/v3/transparentAccounts")
    suspend fun getTransparentAccounts(
        @Header("WEB-API-key") apiKey: String
    ): AccountsResponseDto
}