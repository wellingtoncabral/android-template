package com.br.wcabral.kotlin.android.androidtemplate.presentation.router

interface Router {
    fun back(): Boolean
    fun finishApplication()
    fun showDetail()
}