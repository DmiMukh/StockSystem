package ru.hackathone.core.inventoryApi.product.models
import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class ProductLocation(
    val id: Int,
    val row: String,
    val place: String
) : Parcelable {
    constructor() : this(
        id = -1,
        row = "",
        place = ""
    )
}