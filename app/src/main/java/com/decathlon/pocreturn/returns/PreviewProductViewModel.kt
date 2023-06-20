package com.decathlon.pocreturn.returns

import com.decathlon.pocreturn.returns.data.enum.ReasonType
import com.decathlon.pocreturn.returns.data.model.Product
import com.decathlon.pocreturn.returns.ui.views.productlist.generateProduct

class PreviewProductViewModel : ProductViewModelInterface {
    override val products = listOf(generateProduct(), generateProduct())
    override val reason: ReasonType = ReasonType.Defective
    override fun addProduct(product: Product) = Unit
    override fun removeProduct(product: Product) = Unit
    override fun setReason(reason: ReasonType) = Unit
}
