package com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.items

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.br.wcabral.kotlin.android.androidtemplate.domain.Result
import com.br.wcabral.kotlin.android.androidtemplate.domain.interactor.LoadItemsUseCase
import com.br.wcabral.kotlin.android.androidtemplate.presentation.binding.Item
import com.br.wcabral.kotlin.android.androidtemplate.presentation.mapper.toEntity
import com.br.wcabral.kotlin.android.androidtemplate.presentation.router.Router
import com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.base.BaseViewModel
import com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.base.ViewState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class ItemsViewModel(
    private val loadItemsUseCase: LoadItemsUseCase,
    private val router: Router
) : BaseViewModel() {

    private val _loadItemsObservable = MutableLiveData<ViewState<List<Item>>>()
    val loadItemsObservable: LiveData<ViewState<List<Item>>> get() = _loadItemsObservable

    fun loadItems() {
        loadItemsUseCase.invoke(Dispatchers.IO, null)
            .onStart {
                _loadItemsObservable.value = ViewState.Loading
            }
            .onEach { result ->
                _loadItemsObservable.value = when(result) {
                    is Result.Success -> ViewState.Success(result.data.map { it.toEntity() })
                    is Result.Error -> ViewState.Error(result.exception)
                    else -> throw IllegalArgumentException()
                }
            }
            .catch { error ->
                _loadItemsObservable.value = ViewState.Error(error)
            }
            .launchIn(viewModelScope)
    }

    fun showDetailScreen() {
        router.showDetail()
    }
}
