package com.br.wcabral.kotlin.android.androidtemplate.framework.di

import androidx.fragment.app.FragmentManager
import com.br.wcabral.kotlin.android.androidtemplate.presentation.router.Router
import com.br.wcabral.kotlin.android.androidtemplate.presentation.router.RouterImpl
import org.koin.dsl.module

val routerModule = module {

    factory<Router> { (supportFragmentManager: FragmentManager) ->
        RouterImpl(supportFragmentManager)
    }

}