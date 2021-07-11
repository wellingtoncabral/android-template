package com.br.wcabral.kotlin.android.androidtemplate.domain.interactor.base

import com.br.wcabral.kotlin.android.androidtemplate.domain.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class UseCase<Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Type

    suspend operator fun invoke(
        dispatcher: CoroutineDispatcher,
        params: Params
    ): Result<Type> {
        return try {
            Result.Success(withContext(dispatcher) { run(params) })
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }
    }
}
