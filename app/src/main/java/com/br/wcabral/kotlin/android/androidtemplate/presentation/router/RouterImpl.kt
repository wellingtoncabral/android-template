package com.br.wcabral.kotlin.android.androidtemplate.presentation.router

import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.fragment.NavHostFragment
import com.br.wcabral.kotlin.android.androidtemplate.R
import com.br.wcabral.kotlin.android.androidtemplate.presentation.ui.items.ItemsFragmentDirections

class RouterImpl(
    private val supportFragmentManager: FragmentManager
) : Router {

    private val navController: NavController by lazy {
        (supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment)
            .navController
    }

    private val navGraph: NavGraph by lazy {
        navController.navInflater.inflate(R.navigation.nav_graph)
    }

    override fun back() = navController.popBackStack()

    override fun finishApplication() {
        navController.popBackStack(R.id.nav_graph, true)
    }

    override fun showDetail() {
        navController.navigate(
            ItemsFragmentDirections.actionItemsFragmentToDetailFragment()
        )
    }

}