package com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.items

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.br.wcabral.kotlin.android.androidtemplate.databinding.FragmentItemsBinding
import com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf

class ItemsFragment: BaseFragment() {

    private val viewModel: ItemsViewModel by viewModel {
        parametersOf(router)
    }

    private var binding: FragmentItemsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemsBinding.inflate(layoutInflater, container, false).apply {
            lifecycleOwner = this@ItemsFragment
            viewModel = this@ItemsFragment.viewModel
        }

        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}