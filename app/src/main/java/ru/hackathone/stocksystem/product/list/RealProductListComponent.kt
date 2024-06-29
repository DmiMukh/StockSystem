package ru.hackathone.stocksystem.product.list

import android.content.res.Resources
import com.arkivanov.decompose.ComponentContext
import com.arkivanov.essenty.instancekeeper.InstanceKeeper
import com.arkivanov.essenty.instancekeeper.getOrCreate
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.hackathone.core.inventoryApi.exceptions.BadRequestException
import ru.hackathone.core.inventoryApi.exceptions.UnknownStatusCodeException
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.core.inventoryApi.product.service.ProductService
import ru.hackathone.core.message.data.MessageService
import ru.hackathone.core.message.domain.Message
import ru.hackathone.core.utils.StaffRole
import ru.hackathone.core.utils.USER_PATH
import ru.hackathone.core.utils.componentScope
import ru.hackathone.stocksystem.order.list.OrderListState
import ru.hackathone.stocksystem.order.list.RealOrderListComponent
import ru.hackathone.stocksystem.product.list.toolbar.RealProductListToolbarComponent

class RealProductListComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onDetails: (Product) -> Unit,
    private val service: ProductService,
    private val messageService: MessageService
) : ComponentContext by componentContext,  ProductListComponent {

    private val componentInstance = instanceKeeper.getOrCreate(RealProductListComponent::ProductListKeeper)

    override val toolbarComponent = RealProductListToolbarComponent(
        componentContext = componentContext,
        onBack = { onBack.invoke() },
        onRefresh = { refreshProducts() }
    )
    override val viewState get() = componentInstance.viewState

    override fun onAddProductClick() {
        messageService.showMessage(Message("Not Implemented Yet"))
        //onDetails.invoke(Product(id = -1, name = "New Product"))
    }

    override fun onProductClick(product: Product) {
        messageService.showMessage(Message("Not Implemented Yet"))
    }

    private class ProductListKeeper :  InstanceKeeper.Instance {
        val viewState = MutableStateFlow<ProductListState>(ProductListState.Idle)

        override fun onDestroy() = Unit
    }

    private fun refreshProducts() {
        viewState.update { ProductListState.Loading }

        componentScope.launch {
            try {

                val products = service.getProductList()

                if (products.isEmpty()) {
                    viewState.update { ProductListState.NoItems }
                    return@launch
                }

                viewState.update { ProductListState.Display(products.asList()) }

            } catch (ex: Resources.NotFoundException) {
                messageService.showMessage(Message(text = "Not Found!"))
                viewState.update { ProductListState.Idle }
            } catch (ex: BadRequestException) {
                messageService.showMessage(Message(text = "Bad Request!"))
                viewState.update { ProductListState.Idle }
            } catch (ex: UnknownStatusCodeException) {
                messageService.showMessage(Message(text = "Unknown Status Code!"))
                viewState.update { ProductListState.Idle }
            }

            return@launch
        }
    }
}