package ru.hackathone.stocksystem.order.details.toolbar

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
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.core.utils.ICON_SIZE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailsToolbarUi(component: OrderDetailsToolbarComponent) {
    TopAppBar(
        title = { Text(text = "Order Details") },
        navigationIcon = {
            IconButton(onClick = component::onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "arrow_back",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
    )
}

@Composable
fun OrderDetailsToolbarUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        OrderDetailsToolbarUi(FakeOrderDetailsToolbarComponent())
    }
}

@Preview(name = "light")
@Composable
fun OrderDetailsToolbarUiPreviewLight(){
    OrderDetailsToolbarUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun OrderDetailsToolbarUiPreviewDark(){
    OrderDetailsToolbarUiPreview(darkTheme = true)
}