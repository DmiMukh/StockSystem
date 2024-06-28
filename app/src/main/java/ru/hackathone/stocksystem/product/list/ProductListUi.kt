package ru.hackathone.stocksystem.product.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.core.utils.ICON_SIZE
import ru.hackathone.stocksystem.product.list.toolbar.ProductListToolbarUi

@Composable
fun ProductListUi(component: ProductListComponent){
    Scaffold(
        topBar = { ProductListToolbarUi(component.toolbarComponent) },
        floatingActionButton = {
            IconButton(onClick = component::onAddProductClick) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "arrow_back",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            Row {
                Text(text = "Count:", modifier = Modifier.padding(end = 4.dp))
                Text(text = "0")
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