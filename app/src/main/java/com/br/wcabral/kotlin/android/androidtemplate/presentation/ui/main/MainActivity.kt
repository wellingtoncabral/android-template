package com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.main

import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.br.wcabral.kotlin.android.androidtemplate.R
import com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.base.ViewState
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel by viewModel<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.loadItemsObservable.observe(this) { viewState ->
            when (viewState) {
                is ViewState.Loading -> Log.d("WELL", "Carregando")
                is ViewState.Success -> Log.d("WELL", "Sucesso: ${viewState.data}")
                is ViewState.Error -> Log.e("WELL", "Erro", viewState.exception)
            }
        }

        findViewById<Button>(R.id.button).setOnClickListener {
            viewModel.loadItems()
        }

//        viewModel.addItem(Item(0, "Estudar flow", false))


    }
}
