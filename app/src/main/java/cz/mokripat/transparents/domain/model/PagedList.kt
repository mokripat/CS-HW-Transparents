package cz.mokripat.transparents.domain.model

/**
 * Domain representation a paged list of items with loading and error indication.
 */
data class PagedList<T>(
    val items: List<T> = emptyList(),
    val isLoading: Boolean = true,
    val isNextLoading: Boolean = false,
    val error: Throwable? = null,
    val currentPage: Int = 0,
    val totalPages: Int = Int.MAX_VALUE,
) {
    val hasNextPage: Boolean
        get() = currentPage < totalPages
}