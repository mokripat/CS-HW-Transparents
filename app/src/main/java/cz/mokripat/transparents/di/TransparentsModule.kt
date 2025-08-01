package cz.mokripat.transparents.di

import cz.mokripat.transparents.BuildConfig
import cz.mokripat.transparents.data.repository.AccountsRepositoryImpl
import cz.mokripat.transparents.domain.repository.AccountsRepository
import cz.mokripat.transparents.domain.usecase.GetAccountByIban
import cz.mokripat.transparents.domain.usecase.LoadNextAccountPage
import cz.mokripat.transparents.domain.usecase.ObserveAccountsPagedList
import cz.mokripat.transparents.domain.usecase.RefreshAccounts
import cz.mokripat.transparents.ui.screens.detail.viewModel.AccountDetailViewModel
import cz.mokripat.transparents.ui.screens.list.viewmodel.AccountsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val transparentsModule = module {
    single<AccountsRepository> {
        AccountsRepositoryImpl(
            api = get(),
            apiKey = BuildConfig.API_KEY
        )
    }

    factoryOf(::LoadNextAccountPage)
    factoryOf(::ObserveAccountsPagedList)
    factoryOf(::RefreshAccounts)
    factoryOf(::GetAccountByIban)

    viewModelOf(::AccountsViewModel)
    viewModel { (iban: String) -> AccountDetailViewModel(iban, get()) }
}