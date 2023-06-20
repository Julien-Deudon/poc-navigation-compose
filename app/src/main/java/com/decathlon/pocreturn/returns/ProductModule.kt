package com.decathlon.pocreturn.returns

import androidx.lifecycle.SavedStateHandle
import com.decathlon.pocreturn.returns.ui.views.summary.viewModel.HttpViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val productModule = module {
    viewModel { (state: SavedStateHandle) -> ProductViewModel(state) }
    viewModel { HttpViewModel() }
}
