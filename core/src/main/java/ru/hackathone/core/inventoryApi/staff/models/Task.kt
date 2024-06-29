package ru.hackathone.core.inventoryApi.staff.models

import com.arkivanov.essenty.parcelable.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Parcelize
@Serializable
data class Task(
    val id: Int,
    val title: String,
    val description: String,
    @SerialName("status_id")
    val statusId: Int,
    @SerialName("user_id")
    val userId: Int
) : Parcelable {
    constructor() : this (
        id = -1,
        title = "",
        description = "",
        statusId = 0,
        userId = 0
    )
}