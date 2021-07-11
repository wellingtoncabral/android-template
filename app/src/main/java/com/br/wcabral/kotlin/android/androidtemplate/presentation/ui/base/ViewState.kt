package com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.base

sealed class ViewState<out T> {
    object Loading : ViewState<Nothing>()
    data class Success<out T>(val data: T) : ViewState<T>()
    data class Error(val exception: Throwable) : ViewState<Nothing>()
}
