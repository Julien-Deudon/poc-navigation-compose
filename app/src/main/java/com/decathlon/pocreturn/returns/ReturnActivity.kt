package com.decathlon.pocreturn.returns

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.decathlon.pocreturn.returns.ui.views.productlist.ProductList
import com.decathlon.pocreturn.returns.ui.views.reason.ReasonScreen
import com.decathlon.pocreturn.returns.ui.views.summary.ProductSummary
import com.decathlon.pocreturn.returns.ui.views.summary.viewModel.HttpViewModel
import org.koin.androidx.compose.getViewModel

class ReturnActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Content()
        }
    }
}

@Composable
fun Content() {
    val productViewModel: ProductViewModel = getViewModel()
    val httpViewModel: HttpViewModel = getViewModel()
    val navController = rememberNavController()
    val navigationManager = NavigationManager(navController)

    NavHost(
        navController,
        startDestination = "productListView",
    ) {
        composable("productListView") {
            ProductList(
                viewModel = productViewModel,
                navigationManager = navigationManager
            )
        }
        composable("reasonView") { ReasonScreen(navigationManager, productViewModel) }
        composable("productSummaryView") {
            ProductSummary(
                productViewModel = productViewModel,
                httpViewModel = httpViewModel,
                navigationManager = navigationManager
            )
        }
    }
}
