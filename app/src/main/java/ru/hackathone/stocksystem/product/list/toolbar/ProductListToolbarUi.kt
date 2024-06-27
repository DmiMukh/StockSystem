package ru.hackathone.stocksystem.product.list.toolbar

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme

@Composable
fun ProductListToolbarUi(component: ProductListToolbarComponent){

}

@Composable
fun ProductListToolbarUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        ProductListToolbarUi(FakeProductListToolbarComponent())
    }
}

@Preview(name = "light")
@Composable
fun ProductListToolbarUiPreviewLight(){
    ProductListToolbarUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun ProductListToolbarUiPreviewDark(){
    ProductListToolbarUiPreview(darkTheme = true)
}