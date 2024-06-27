package ru.hackathone.stocksystem.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.stocksystem.home.toolbar.HomeToolbarUi

@Composable
fun HomeUi(component: HomeComponent) {
    Scaffold (
        topBar = { HomeToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column (
            modifier = Modifier
                .fillMaxWidth()
                .padding(paddingValues)
        ) {
            MenuButton(
                title = "Product",
                onClick = {}
            )

            MenuButton(
                title = "Staff",
                onClick = {}
            )
        }
    }
}

@Composable
fun MenuButton(
    title: String,
    onClick: () -> Unit
){
    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        Text(
            text = title,
            fontSize = 24.sp
        )
    }
}

@Composable
fun HomeUiPreview(darkTheme: Boolean) {
    AppTheme(
        darkTheme = darkTheme
    ) {
        HomeUi(FakeHomeComponent())
    }
}

@Preview(name = "light")
@Composable
fun HomeUiPreviewLight() {
    HomeUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun HomeUiPreviewDark() {
    HomeUiPreview(darkTheme = true)
}