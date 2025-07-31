package cz.mokripat.transparents.di

import cz.mokripat.transparents.BuildConfig
import cz.mokripat.transparents.data.api.AccountsApi
import cz.mokripat.transparents.data.repository.AccountsRepositoryImpl
import cz.mokripat.transparents.domain.repository.AccountsRepository
import okhttp3.OkHttpClient
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val transparentsModule = module {
    single<AccountsRepository> {
        AccountsRepositoryImpl(
            api = get(),
            apiKey = BuildConfig.API_KEY
        )
    }
}

val networkModule = module {
    single {
        OkHttpClient.Builder()
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BuildConfig.BASE_URL)
            .client(get())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create(AccountsApi::class.java)
    }
}