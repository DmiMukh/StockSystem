package ru.hackathone.stocksystem.home.toolbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
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
fun HomeToolbarUi(component: HomeToolbarComponent) {
    TopAppBar(
        title = { Text(text = "Stock System") },
        actions = {
            IconButton(onClick = component::onLogOut) {
                Icon(
                    painter = painterResource(R.drawable.ic_logout),
                    contentDescription = "logout",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
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