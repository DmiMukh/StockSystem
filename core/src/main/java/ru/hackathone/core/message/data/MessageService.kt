package ru.hackathone.core.message.data

import kotlinx.coroutines.flow.Flow
import ru.hackathone.core.message.domain.Message

interface MessageService {

    val messageFlow: Flow<Message>

    fun showMessage(message: Message)
}