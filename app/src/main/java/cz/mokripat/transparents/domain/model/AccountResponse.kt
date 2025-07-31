package cz.mokripat.transparents.domain.model

data class AccountsResponse(
    val pageNumber: Int,
    val pageSize: Int,
    val pageCount: Int,
    val nextPage: Int?,
    val recordCount: Int,
    val accounts: List<Account>
)