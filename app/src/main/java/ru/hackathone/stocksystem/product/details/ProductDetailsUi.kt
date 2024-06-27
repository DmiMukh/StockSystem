package ru.hackathone.stocksystem.product.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.stocksystem.product.details.toolbar.ProductDetailsToolbarUi

@Composable
fun ProductDetailsUi(component: ProductDetailsComponent){
    Scaffold(
        topBar = { ProductDetailsToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {

        }
    }
}

@Composable
fun ProductDetailsUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        ProductDetailsUi(FakeProductDetailsComponent())
    }
}

@Preview(name = "light")
@Composable
fun ProductDetailsUiPreviewLight(){
    ProductDetailsUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun ProductDetailsUiPreviewDark(){
    ProductDetailsUiPreview(darkTheme = true)
}