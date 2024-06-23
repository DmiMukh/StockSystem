package ru.hackathone.stocksystem.home.toolbar

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import ru.hackathone.core.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeToolbarUi(component: HomeToolbarComponent) {
    TopAppBar(
        title = { Text(text = "Stock System") }
    )
}

@Composable
fun HomeToolbarUiPreview(darkTheme: Boolean) {
    AppTheme(darkTheme = darkTheme) {
        HomeToolbarUi(FakeHomeToolbarComponent())
    }
}

@Preview(name = "light")
@Composable
fun HomeToolbarUiPreviewLight() {
    HomeToolbarUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun HomeToolbarUiPreviewDark() {
    HomeToolbarUiPreview(darkTheme = true)
}