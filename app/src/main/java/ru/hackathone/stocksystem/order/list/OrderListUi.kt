package ru.hackathone.stocksystem.order.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.stocksystem.order.list.item.OrderItem
import ru.hackathone.stocksystem.order.list.toolbar.OrderListToolbarUi

@Composable
fun OrderListUi(component: OrderListComponent) {

    val viewState = component.viewState.collectAsState()

    Scaffold(
        topBar = { OrderListToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            when(val state = viewState.value) {
                is OrderListState.Display -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        state.items.forEach { model ->
                            item {
                                OrderItem(
                                    model = model,
                                    onClick = {  }
                                )
                            }
                        }
                    }
                }
                OrderListState.Loading -> TODO()
                OrderListState.NoItems -> OrderListNoItems()
            }
        }
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}

@Composable
fun OrderListNoItems(modifier: Modifier = Modifier){
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier.size(96.dp),
            imageVector = Icons.Filled.Info,
            contentDescription = "No Items Found"
        )

        Text(
            modifier = Modifier.padding(top = 16.dp, bottom = 24.dp),
            text = "Нет данных",
            textAlign = TextAlign.Center
        )
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