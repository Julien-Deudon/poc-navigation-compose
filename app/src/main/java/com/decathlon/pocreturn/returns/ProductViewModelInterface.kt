package com.decathlon.pocreturn.returns

import com.decathlon.pocreturn.returns.data.enum.ReasonType
import com.decathlon.pocreturn.returns.data.model.Product

interface ProductViewModelInterface {
    val products: List<Product>
    val reason: ReasonType?
    fun addProduct(product: Product)
    fun removeProduct(product: Product)
    fun setReason(reason: ReasonType)
}
