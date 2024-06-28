package ru.hackathone.stocksystem.settings

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.core.storage.SettingsStorage
import ru.hackathone.core.utils.AUTH_HOST_PATH
import ru.hackathone.core.utils.PRODUCT_HOST_PATH
import ru.hackathone.core.utils.STAFF_HOST_PATH
import ru.hackathone.stocksystem.settings.toolbar.RealSettingsToolbarComponent

class RealSettingsComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val storage: SettingsStorage
): ComponentContext by componentContext, SettingsComponent {

    private val componentInstance = instanceKeeper.getOrCreate(::SettingsKeeper)

    override val toolbarComponent = RealSettingsToolbarComponent(
        componentContext = componentContext,
        onBack = this.onBack,
        onSave = { this.onSave() }
    )
    override val authServiceHost get() = componentInstance.authHost
    override val productServiceHost get() = componentInstance.productHost
    override val staffServiceHost get() = componentInstance.staffHost

    override fun onAuthServiceHostChange(newValue: String) {
        this.authServiceHost.value = newValue
    }

    override fun onProductServiceHostChange(newValue: String) {
        this.productServiceHost.value = newValue
    }

    override fun onStaffServiceHostChange(newValue: String) {
        this.staffServiceHost.value = newValue
    }

    private fun onSave() {
        storage.putString(AUTH_HOST_PATH, this.authServiceHost.value)
        storage.putString(PRODUCT_HOST_PATH, this.productServiceHost.value)
        storage.putString(STAFF_HOST_PATH, this.staffServiceHost.value)

        onBack.invoke()
    }

    private class SettingsKeeper :  InstanceKeeper.Instance {

        val isInit = false

        val authHost = MutableStateFlow("")
        val productHost = MutableStateFlow("")
        val staffHost = MutableStateFlow("")

        override fun onDestroy() = Unit
    }

    init {
        if(!componentInstance.isInit) {
            this.authServiceHost.value = storage.getString(AUTH_HOST_PATH)
            this.productServiceHost.value = storage.getString(PRODUCT_HOST_PATH)
            this.staffServiceHost.value = storage.getString(STAFF_HOST_PATH)
        }
    }
}