package ru.hackathone.core

import android.content.res.Resources.NotFoundException
import com.arkivanov.decompose.ComponentContext
import io.ktor.client.HttpClient
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import ru.hackathone.core.message.ui.MessageComponent
import org.koin.core.component.get
import org.koin.dsl.module
import ru.hackathone.core.inventoryApi.userAuth.client.AuthorizationClient
import ru.hackathone.core.inventoryApi.userAuth.client.AuthorizationClientImpl
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
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.statement.HttpResponse
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.http.HttpStatusCode
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.NoContentException
import ru.hackathone.core.inventoryApi.staff.client.StaffClient
import ru.hackathone.core.inventoryApi.staff.client.StaffClientImpl
import ru.hackathone.core.inventoryApi.staff.service.StaffService
import ru.hackathone.core.inventoryApi.staff.service.StaffServiceImpl
import ru.hackathone.core.inventoryApi.userAuth.service.AuthorizationServiceImpl
import ru.hackathone.core.storage.SettingsStorage
import ru.hackathone.core.storage.SettingsStorageImpl
import ru.hackathone.core.utils.AUTH_HOST_PATH
import ru.hackathone.core.utils.STAFF_HOST_PATH

val coreModule = module {
    single<CoroutineScope> { provideAppScope() }
    single<MessageService> { MessageServiceImpl() }
    single<SettingsStorage> { SettingsStorageImpl(context = get()) }
    single<AuthorizationClient> {
        AuthorizationClientImpl(
            client = provideKtorHttpClient(),
            addr = "http://".plus(get<SettingsStorage>().getString(AUTH_HOST_PATH))
        )
    }
    single<AuthorizationServiceImpl> { AuthorizationServiceImpl(client = get<AuthorizationClientImpl>()) }
    single<StaffClient> {
        StaffClientImpl(
            client = provideKtorHttpClient(),
            addr = "http://".plus(get<SettingsStorage>().getString(STAFF_HOST_PATH))
        )
    }
    single<StaffService> { StaffServiceImpl(client = get()) }
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

        HttpResponseValidator {
            validateResponse { response: HttpResponse ->
                val statusCode = response.status.value

                when (statusCode) {
                    404 -> throw NotFoundException()
                    400 -> throw BadRequestException()
                    204 -> throw NoContentException()
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