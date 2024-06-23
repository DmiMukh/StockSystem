package ru.hackathone.core.message.domain

import androidx.annotation.DrawableRes

data class Message(
    val text: String,
    @DrawableRes val iconRes: Int? = null,
    val actionTitle: String? = null,
    val action: (() -> Unit)? = null
)
