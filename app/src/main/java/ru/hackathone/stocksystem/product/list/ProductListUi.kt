package ru.hackathone.stocksystem.product.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.stocksystem.product.list.toolbar.ProductListToolbarUi

@Composable
fun ProductListUi(component: ProductListComponent){
    Scaffold(
        topBar = { ProductListToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
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