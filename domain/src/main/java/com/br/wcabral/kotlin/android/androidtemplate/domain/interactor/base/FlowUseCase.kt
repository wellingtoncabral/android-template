package com.br.wcabral.kotlin.android.androidtemplate.domain.interactor.base

import com.br.wcabral.kotlin.android.androidtemplate.domain.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.*

abstract class FlowUseCase<Type, in Params> where Type : Any {

    abstract fun run(params: Params): Flow<Type>

    @Suppress("USELESS_CAST")
    operator fun invoke(
            dispatcher: CoroutineDispatcher,
            params: Params
    ): Flow<Result<Type>> {
        return run(params)
            .map { Result.Success(it) as Result<Type> }
            .catch { emit(Result.Error(it)) }
            .flowOn(dispatcher)
    }

}
