package cz.mokripat.transparents.domain.model

data class Account(
    val accountNumber: String,
    val bankCode: String,
    val transparencyFrom: String,
    val transparencyTo: String,
    val publicationTo: String,
    val actualizationDate: String,
    val balance: Double,
    val currency: String,
    val name: String,
    val iban: String,
    val description: String? = null
)