package ru.hackathone.stocksystem.product.list.item

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.hackathone.core.inventoryApi.product.models.Product
import ru.hackathone.core.theme.AppTheme

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun ProductItem(
    model: Product,
    onClick: (Product) -> Unit
){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .combinedClickable(
                onClick = { onClick(model) },
                onLongClick = { }
            ),
    ) {
        Column {
            Text(text = model.name)
            Text(text = model.description)
        }
    }
}

@Composable
fun ProductItemPreview(darkTheme: Boolean){
    AppTheme(darkTheme = darkTheme) {
        ProductItem(
            model = Product(),
            onClick = {}
        )
    }
}

@Preview(name = "light")
@Composable
fun ProductItemPreviewLight() {
    ProductItemPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun ProductItemPreviewDark() {
    ProductItemPreview(darkTheme = true)
}