package ru.hackathone.core.message.ui

import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.core.message.domain.Message

class FakeMessageComponent : MessageComponent {

    override val visibleMessage = MutableStateFlow(
        Message("Message")
    )

    override fun onActionClick() = Unit
}
