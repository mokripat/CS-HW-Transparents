package cz.mokripat.transparents.domain.model

/**
 * Domain representation of paged list of accounts.
 */
data class AccountsResponse(
    val pageNumber: Int,
    val pageSize: Int,
    val pageCount: Int,
    val nextPage: Int?,
    val recordCount: Int,
    val accounts: List<Account>
)