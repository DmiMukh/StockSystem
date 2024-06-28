package ru.hackathone.core.inventoryApi.product.models

import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Product(
    val id: Int,
    val name: String = "",
    val quantity: Int = 0,
    val description: String = "",
    val category: ProductCategory = ProductCategory(),
    val location: ProductLocation = ProductLocation(),
    val status: ProductStatus = ProductStatus()
) : Parcelable {
    constructor() : this(
        id = -1,
        name = "",
        quantity = 0,
        description = "",
        category = ProductCategory(),
        location = ProductLocation(),
        status = ProductStatus()
    )
}