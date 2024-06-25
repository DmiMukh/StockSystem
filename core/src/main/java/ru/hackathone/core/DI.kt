package ru.hackathone.core

import com.arkivanov.decompose.ComponentContext
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ru.hackathone.core.message.ui.MessageComponent
import org.koin.core.component.get
import org.koin.dsl.module
import ru.hackathone.core.inventoryApi.userAuthClient.AuthClient
import ru.hackathone.core.inventoryApi.userAuthClient.AuthClientKtor
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.data.MessageServiceImpl
import ru.hackathone.core.message.ui.RealMessageComponent
import kotlin.coroutines.EmptyCoroutineContext
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.RedirectResponseException
import io.ktor.client.plugins.ResponseException
import io.ktor.client.plugins.ServerResponseException
import io.ktor.client.statement.HttpResponse

val coreModule = module {
    single<CoroutineScope> { provideAppScope() }
    single<MessageService> { MessageServiceImpl() }
    single<AuthClient> { AuthClientKtor(providedKtorClient = provideKtorHttpClient()) }
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

fun provideKtorHttpClient(): HttpClient {
    return HttpClient(Android) {
        /*
        install(Logging) {
            level = LogLevel.ALL
        }

        install(ContentNegotiation) {
            json(
                json = Json {
                    encodeDefaults = true
                    isLenient = true
                    ignoreUnknownKeys = true
                    allowSpecialFloatingPointValues = true
                }
            )
        }
*/
        HttpResponseValidator {
            validateResponse { response: HttpResponse ->
                val statusCode = response.status.value

                when (statusCode) {
                    in 300..399 -> throw RedirectResponseException(response, response.toString())
                    in 400..499 -> throw ClientRequestException(response, response.toString())
                    in 500..599 -> throw ServerResponseException(response, response.toString())
                }

                if (statusCode >= 600) {
                    throw ResponseException(response, response.toString())
                }
            }

            handleResponseExceptionWithRequest { cause, _ -> throw cause }
        }
    }
}