package ru.hackathone.stocksystem.product.details.toolbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
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
fun ProductDetailsToolbarUi(component: ProductDetailsToolbarComponent){
    TopAppBar(
        title = { Text(text = "Product Details") },
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
            IconButton(onClick = component::onSaveClick) {
                Icon(
                    painter = painterResource(R.drawable.ic_save),
                    contentDescription = "save",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
    )
}

@Composable
fun ProductDetailsToolbarUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        ProductDetailsToolbarUi(FakeProductDetailsToolbarComponent())
    }
}

@Preview(name = "light")
@Composable
fun ProductDetailsToolbarUiPreviewLight(){
    ProductDetailsToolbarUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun ProductDetailsToolbarUiPreviewDark(){
    ProductDetailsToolbarUiPreview(darkTheme = true)
}