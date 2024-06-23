package ru.hackathone.core.message.ui

import kotlinx.coroutines.flow.StateFlow
import ru.hackathone.core.message.domain.Message

interface MessageComponent {
    val visibleMessage: StateFlow<Message?>

    fun onActionClick()
}