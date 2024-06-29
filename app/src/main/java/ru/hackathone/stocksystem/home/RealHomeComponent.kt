package ru.hackathone.stocksystem.home

import com.arkivanov.decompose.ComponentContext
import kotlinx.coroutines.flow.MutableStateFlow
import ru.hackathone.core.storage.SettingsStorage
import ru.hackathone.core.utils.ROLE_PATH
import ru.hackathone.stocksystem.home.toolbar.RealHomeToolbarComponent

class RealHomeComponent(
    componentContext: ComponentContext,
    private val onOrder: () -> Unit,
    private val onProduct: () -> Unit,
    private val onStaff: () -> Unit,
    private val storage: SettingsStorage
) : ComponentContext by componentContext, HomeComponent {

    override val toolbarComponent = RealHomeToolbarComponent(
        componentContext = componentContext
    )
    override val roleId = MutableStateFlow(100)

    override fun onOrderClick() = this.onOrder.invoke()

    override fun onProductClick() = this.onProduct.invoke()

    override fun onStaffClick()  = this.onStaff.invoke()

    init {
        roleId.value = storage.getInt(ROLE_PATH)
    }
}