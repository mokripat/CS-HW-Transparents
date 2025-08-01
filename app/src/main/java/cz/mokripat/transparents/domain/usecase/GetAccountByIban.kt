package cz.mokripat.transparents.domain.usecase

import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.repository.AccountsRepository

/**
 * Use case for obtaining account by its IBAN.
 */
class GetAccountByIban(private val repository: AccountsRepository) {
    operator fun invoke(iban: String): Account? = repository.getAccountByIban(iban)
}