package com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.base

import androidx.fragment.app.Fragment
import com.br.wcabral.kotlin.android.androidtemplate.presentation.router.Router
import com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.MainActivity

open class BaseFragment: Fragment() {

    val router: Router
        get() = (activity as MainActivity).router

}