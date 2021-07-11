package com.br.wcabral.kotlin.android.androidtemplate.domain.interactor.base

import com.br.wcabral.kotlin.android.androidtemplate.domain.Result
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.shareIn
import kotlinx.coroutines.flow.SharingStarted

abstract class StateFlowUseCase<Type, in Params> where Type : Any {

    abstract fun run(params: Params): Flow<Type>

    operator fun invoke(
            externalScope: CoroutineScope,
            dispatcher: CoroutineDispatcher,
            params: Params
    ): SharedFlow<Result<Type>> {
        return run(params)
            .map { Result.Success(it) }
            .catch { Result.Error(it) }
            .flowOn(dispatcher)
            .shareIn(
                    externalScope,
                    replay = 1,
                    started = SharingStarted.WhileSubscribed()
            )
    }
}
