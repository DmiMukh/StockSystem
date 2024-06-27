package ru.hackathone.stocksystem.product.details

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme

@Composable
fun ProductDetailsUi(component: ProductDetailsComponent){

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