package ru.hackathone.stocksystem.product.list

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme

@Composable
fun ProductListUi(component: ProductListComponent){

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