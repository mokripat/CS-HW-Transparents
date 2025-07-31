package cz.mokripat.transparents.data.dto

import com.google.gson.annotations.SerializedName

data class AccountsResponseDto(
    @SerializedName("pageNumber")
    val pageNumber: Int,
    @SerializedName("pageSize")
    val pageSize: Int,
    @SerializedName("pageCount")
    val pageCount: Int,
    @SerializedName("nextPage")
    val nextPage: Int?,
    @SerializedName("recordCount")
    val recordCount: Int,
    @SerializedName("accounts")
    val accounts: List<AccountDto>
)