package cz.mokripat.transparents.data.dto

import com.google.gson.annotations.SerializedName

data class AccountDto(
    @SerializedName("accountNumber")
    val accountNumber: String,
    @SerializedName("bankCode")
    val bankCode: String,
    @SerializedName("transparencyFrom")
    val transparencyFrom: String,
    @SerializedName("transparencyTo")
    val transparencyTo: String,
    @SerializedName("publicationTo")
    val publicationTo: String,
    @SerializedName("actualizationDate")
    val actualizationDate: String,
    @SerializedName("balance")
    val balance: Double,
    @SerializedName("currency")
    val currency: String?,
    @SerializedName("name")
    val name: String,
    @SerializedName("iban")
    val iban: String,
    @SerializedName("description")
    val description: String? = null
)