package com.decathlon.pocreturn.returns.ui.views.summary.viewModel

import com.decathlon.pocreturn.returns.data.model.Product

interface HttpViewModelInterface {
    fun validateReturn(products: List<Product>)
}
