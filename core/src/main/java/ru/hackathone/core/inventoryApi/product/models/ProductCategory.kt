package ru.hackathone.core.inventoryApi.product.models

import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ProductCategory(
    val id: Int,
    val name: String
) : Parcelable {
    constructor() : this(
        id = -1,
        name = ""
    )
}