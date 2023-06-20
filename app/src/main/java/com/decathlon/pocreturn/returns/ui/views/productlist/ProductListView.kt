package com.decathlon.pocreturn.returns.ui.views.productlist

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.decathlon.pocreturn.returns.NavigationManager
import com.decathlon.pocreturn.returns.PreviewProductViewModel
import com.decathlon.pocreturn.returns.ProductViewModelInterface
import com.decathlon.pocreturn.returns.data.model.Product
import com.decathlon.pocreturn.returns.ui.widget.ProductItem
import java.util.UUID
import kotlin.random.Random
@Composable
fun ProductList(
    viewModel: ProductViewModelInterface,
    navigationManager: NavigationManager
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(onClick = { viewModel.addProduct(generateProduct()) }) {
            Text("Ajouter un produit")
        }

        LazyColumn {
            items(viewModel.products.size) { index ->
                ProductItem(viewModel.products[index], onRemoveClick = viewModel::removeProduct)
            }
        }

        Button(
            onClick = { navigationManager.goToReasonView() },
            enabled = viewModel.products.isNotEmpty()
        ) {
            Text("Resumé de selection")
        }
    }
}

fun generateProduct(): Product {
    val id = UUID.randomUUID().toString()
    val name = "Product $id"
    val price = Random.nextDouble(1.0, 100.0)

    return Product(id, name, price)
}

@Preview
@Composable
fun PreviewProductList() {
    ProductList(
        viewModel = PreviewProductViewModel(),
        navigationManager = NavigationManager(NavController(LocalContext.current))
    )
}
