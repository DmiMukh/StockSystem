package ru.hackathone.stocksystem.order.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.stocksystem.order.details.toolbar.OrderDetailsToolbarUi

@Composable
fun OrderDetailsUi(component: OrderDetailsComponent) {
    Scaffold(
        topBar = { OrderDetailsToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}

@Composable
fun OrderDetailsUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        OrderDetailsUi(FakeOrderDetailsComponent())
    }
}

@Preview(name = "light")
@Composable
fun OrderDetailsUiPreviewLight(){
    OrderDetailsUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun OrderDetailsUiPreviewDark(){
    OrderDetailsUiPreview(darkTheme = true)
}