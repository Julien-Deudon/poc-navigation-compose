package com.decathlon.pocreturn.returns

import androidx.navigation.NavController

class NavigationManager(private val navController: NavController) {
    fun goToProductList() {
        if (navController.currentBackStack.value.any { it.destination.route == "productListView" }) {
            navController.popBackStack("productListView",
                inclusive = false, saveState = false)
        } else {
            navController.navigate("productListView")
        }

    }

    fun goToReasonView() {
        navController.navigate("reasonView")
    }

    fun pop() {
        navController.popBackStack()
    }

    fun goToProductSummaryView() {
        navController.navigate("productSummaryView")
    }
}