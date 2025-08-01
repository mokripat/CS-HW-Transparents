package cz.mokripat.transparents.domain.usecase

import cz.mokripat.transparents.domain.model.Account
import cz.mokripat.transparents.domain.repository.AccountsRepository

class GetAccountByIban(private val repository: AccountsRepository) {
    operator fun invoke(iban: String): Account? = repository.getAccountByIban(iban)
}