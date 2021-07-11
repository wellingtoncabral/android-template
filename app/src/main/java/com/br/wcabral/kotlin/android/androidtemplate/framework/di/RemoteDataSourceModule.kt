package com.br.wcabral.kotlin.android.androidtemplate.framework.di

import com.br.wcabral.kotlin.android.androidtemplate.data.source.ItemRemoteDataSource
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.remote.ApiService
import com.br.wcabral.kotlin.android.androidtemplate.framework.datasource.remote.ItemRemoteDataSourceImpl
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val remoteDataSourceModule = module {

    // Retrofit
    single {
        Retrofit.Builder()
            .baseUrl("https://fake.url.com")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    // Services
    factory<ApiService> {
        get<Retrofit>().create(ApiService::class.java)
    }

    // Data sources
    factory<ItemRemoteDataSource> { ItemRemoteDataSourceImpl(
        apiService = get()
    )}
}