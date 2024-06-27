package ru.hackathone.stocksystem.order.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.stocksystem.order.list.toolbar.OrderListToolbarUi

@Composable
fun OrderListUi(component: OrderListComponent) {
    Scaffold(
        topBar = { OrderListToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
        }
    }
}

@Composable
fun OrderListUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        OrderListUi(FakeOrderListComponent())
    }
}

@Preview(name = "light")
@Composable
fun OrderListUiPreviewLight(){
    OrderListUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun OrderListUiPreviewDark(){
    OrderListUiPreview(darkTheme = true)
}