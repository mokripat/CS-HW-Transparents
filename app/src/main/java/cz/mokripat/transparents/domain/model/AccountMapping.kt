package cz.mokripat.transparents.domain.model

import cz.mokripat.transparents.data.dto.AccountDto
import cz.mokripat.transparents.data.dto.AccountsResponseDto

fun AccountsResponseDto.toDomain(): AccountsResponse = AccountsResponse(
    pageNumber = pageNumber,
    pageSize = pageSize,
    pageCount = pageCount,
    nextPage = nextPage,
    recordCount = recordCount,
    accounts = accounts.map { it.toDomain() }
)

fun AccountDto.toDomain(): Account = Account(
    accountNumber = accountNumber,
    bankCode = bankCode,
    transparencyFrom = transparencyFrom,
    transparencyTo = transparencyTo,
    publicationTo = publicationTo,
    actualizationDate = actualizationDate,
    balance = balance,
    currency = currency,
    name = name,
    iban = iban,
    description = description
)