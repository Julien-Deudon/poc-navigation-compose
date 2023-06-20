package com.decathlon.pocreturn.returns.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Product(val id: String, val name: String, val price: Double) : Parcelable
