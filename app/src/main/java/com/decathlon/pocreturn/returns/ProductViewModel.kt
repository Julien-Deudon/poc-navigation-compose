package com.decathlon.pocreturn.returns

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.decathlon.pocreturn.returns.data.enum.ReasonType
import com.decathlon.pocreturn.returns.data.model.Product

class ProductViewModel(private val state: SavedStateHandle) :
    ViewModel(),
    ProductViewModelInterface {

    private val _products = mutableStateListOf<Product>().also { list ->
        state.get<List<Product>>("products")?.let { list.addAll(it) }
    }
    override val products: List<Product> get() = _products

    private val _reason = mutableStateOf(state.get<ReasonType?>("reason"))
    override val reason: ReasonType? get() = _reason.value

    override fun addProduct(product: Product) {
        _products.add(product)
        state["products"] = ArrayList(_products)
    }

    override fun removeProduct(product: Product) {
        _products.remove(product)
        state["products"] = ArrayList(_products)
    }

    override fun setReason(reason: ReasonType) {
        _reason.value = reason
        state["reason"] = reason
    }
}
