package com.br.wcabral.kotlin.android.androidtemplate.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.br.wcabral.kotlin.android.androidtemplate.R
import com.br.wcabral.kotlin.android.androidtemplate.presentation.router.Router
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf

class MainActivity : AppCompatActivity() {

    val router: Router by inject {
        parametersOf(this@MainActivity.supportFragmentManager, this@MainActivity.intent.extras)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
