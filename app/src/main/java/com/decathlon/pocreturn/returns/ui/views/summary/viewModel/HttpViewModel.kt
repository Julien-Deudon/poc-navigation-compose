package com.decathlon.pocreturn.returns.ui.views.summary.viewModel

import androidx.lifecycle.ViewModel
import com.decathlon.pocreturn.returns.data.model.Product

class HttpViewModel : ViewModel(), HttpViewModelInterface {
    override fun validateReturn(products: List<Product>) {
        println(products.toString())
    }
}
