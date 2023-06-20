package com.decathlon.pocreturn.returns.ui.views.reason

import android.annotation.SuppressLint
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.decathlon.pocreturn.returns.NavigationManager
import com.decathlon.pocreturn.returns.ProductViewModel
import com.decathlon.pocreturn.returns.data.enum.ReasonType

@Composable
fun ReasonScreen(navigationManager: NavigationManager, productViewModel: ProductViewModel) {
    ReasonView(
        onBackPress = { navigationManager.pop() },
        onValidate = {
            productViewModel.setReason(it)
            navigationManager.goToProductSummaryView()
        },
        numberOfProduct = productViewModel.products.size
    )
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun ReasonView(
    onBackPress: () -> Unit,
    onValidate: (ReasonType) -> Unit,
    numberOfProduct: Int
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Résumé des produits ($numberOfProduct)") },
                navigationIcon = {
                    IconButton(onClick = { onBackPress() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "back")
                    }
                }
            )
        }
    ) {
        Box(modifier = Modifier.padding(top = 56.dp)) {
            Column(modifier = Modifier.fillMaxWidth()) {
                ReasonType.values().forEach { reason ->
                    ListItem(reason = reason, onValidate = onValidate)
                }
            }
        }
    }
}

@Composable
fun ListItem(reason: ReasonType, onValidate: (ReasonType) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clickable { onValidate(reason) },
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = reason.name,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f)
        )
        Icon(imageVector = Icons.Default.ArrowForward, contentDescription = "Selection")
    }
}

@Preview
@Composable
fun PreviewReasonView() {
    ReasonView(onBackPress = {}, onValidate = {}, numberOfProduct = 3)
}
