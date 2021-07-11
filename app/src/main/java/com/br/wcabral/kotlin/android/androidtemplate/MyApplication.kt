package com.br.wcabral.kotlin.android.androidtemplate

import android.app.Application
import com.br.wcabral.kotlin.android.androidtemplate.framework.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication: Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            modules(
                localDataSourceModule,
                remoteDataSourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule,
                routerModule
            )
        }
    }
}