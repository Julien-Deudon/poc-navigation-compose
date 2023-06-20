package com.decathlon.pocreturn.returns.ui.views.summary

import android.annotation.SuppressLint
import android.app.Activity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.decathlon.pocreturn.returns.NavigationManager
import com.decathlon.pocreturn.returns.PreviewProductViewModel
import com.decathlon.pocreturn.returns.ProductViewModelInterface
import com.decathlon.pocreturn.returns.ui.views.summary.viewModel.HttpViewModelInterface
import com.decathlon.pocreturn.returns.ui.views.summary.viewModel.PreviewHttpViewModel
import com.decathlon.pocreturn.returns.ui.widget.ProductItem

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ProductSummary(
    productViewModel: ProductViewModelInterface,
    httpViewModel: HttpViewModelInterface,
    navigationManager: NavigationManager,
) {
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Résumé des produits") },
                navigationIcon = {
                    IconButton(onClick = { (context as Activity).finish() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(top = 56.dp)) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Box(modifier = Modifier.height(8.dp))
                Text(text = productViewModel.reason!!.name)
                Box(modifier = Modifier.height(8.dp))
                Button(onClick = { navigationManager.goToProductList() }, modifier = Modifier.fillMaxWidth()) {
                    Text("Add a return")
                }
                LazyColumn {
                    items(productViewModel.products.size) { index ->
                        ProductItem(
                            product = productViewModel.products[index],
                            onRemoveClick = null
                        )
                    }
                }
                Button(onClick = {
                    httpViewModel.validateReturn(productViewModel.products)
                }, modifier = Modifier.fillMaxWidth()) {
                    Text("Validate Return")
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewProductSummary() {
    ProductSummary(
        productViewModel = PreviewProductViewModel(),
        httpViewModel = PreviewHttpViewModel(),
        navigationManager = NavigationManager(NavController(LocalContext.current))
    )
}
