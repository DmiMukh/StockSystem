package ru.hackathone.stocksystem.product.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.core.utils.ICON_SIZE
import ru.hackathone.stocksystem.order.list.OrderListNoItems
import ru.hackathone.stocksystem.order.list.OrderListState
import ru.hackathone.stocksystem.order.list.item.OrderItem
import ru.hackathone.stocksystem.product.list.item.ProductListItem
import ru.hackathone.stocksystem.product.list.toolbar.ProductListToolbarUi

@Composable
fun ProductListUi(component: ProductListComponent){

    val viewState = component.viewState.collectAsState()

    Scaffold(
        topBar = { ProductListToolbarUi(component.toolbarComponent) },
        floatingActionButton = {
            IconButton(onClick = component::onAddProductClick) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "add_product",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            when(val state = viewState.value) {
                is ProductListState.Display -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        state.items.forEach { model ->
                            item {
                                ProductListItem(
                                    model = model,
                                    onClick = component::onProductClick,
                                )
                            }
                        }
                    }
                }
                ProductListState.Loading -> CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
                ProductListState.NoItems -> OrderListNoItems(modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
                )
                ProductListState.Idle -> {}
            }
        }
    }
}

@Composable
fun ProductListUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        ProductListUi(FakeProductListComponent())
    }
}

@Preview(name = "light")
@Composable
fun ProductListUiPreviewLight(){
    ProductListUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun ProductListUiPreviewDark(){
    ProductListUiPreview(darkTheme = true)
}