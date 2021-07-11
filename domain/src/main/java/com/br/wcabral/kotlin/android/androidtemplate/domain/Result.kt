package com.br.wcabral.kotlin.android.androidtemplate.domain

sealed class Result<out T: Any> {
    data class Success<out T: Any>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
}

val <T: Any> Result<T>.dataOrNull: T?
    get() = when (this) {
        is Result.Success -> data
        else -> null
    }