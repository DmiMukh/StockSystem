package ru.hackathone.core

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ru.hackathone.core.message.ui.MessageComponent
import org.koin.core.component.get
import org.koin.dsl.module
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.data.MessageServiceImpl
import ru.hackathone.core.message.ui.RealMessageComponent
import kotlin.coroutines.EmptyCoroutineContext

val coreModule = module {
    single<CoroutineScope> { provideAppScope() }
    single<MessageService> { MessageServiceImpl() }
}

fun ComponentFactory.createMessageComponent(
    componentContext: ComponentContext
): MessageComponent {
    return RealMessageComponent(
        componentContext = componentContext,
        messageService = get()
    )
}

fun provideAppScope(): CoroutineScope {
    return CoroutineScope(EmptyCoroutineContext + Dispatchers.Default)
}