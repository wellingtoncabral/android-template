package com.br.wcabral.kotlin.android.androidtemplate.presentation.binding

import android.os.Parcelable
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.library.baseAdapters.BR
import kotlinx.parcelize.Parcelize

@Parcelize
class Item: BaseObservable(), Parcelable {
    @Bindable
    var id: Long = 0
        set(value) {
            field = value
            notifyPropertyChanged(BR.id)
        }

    @Bindable
    var title: String = ""
        set(value) {
            field = value
            notifyPropertyChanged(BR.title)
        }

    @Bindable
    var isDone: Boolean = false
        set(value) {
            field = value
            notifyPropertyChanged(BR.isDone)
        }
}
