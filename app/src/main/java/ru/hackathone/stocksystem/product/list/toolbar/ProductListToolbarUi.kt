package ru.hackathone.stocksystem.product.list.toolbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.core.utils.ICON_SIZE
import ru.hackathone.stocksystem.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListToolbarUi(component: ProductListToolbarComponent){
    TopAppBar(
        title = { Text(text = "Product List") },
        navigationIcon = {
            IconButton(onClick = component::onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "arrow_back",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        },
        actions = {
            IconButton(onClick = component::onRefreshClick) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "refresh",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
    )
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