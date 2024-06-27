package ru.hackathone.stocksystem.signin.toolbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
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
fun SignInToolbarUi(component: SignInToolbarComponent) {
    TopAppBar(
        title = { Text(text = "Stock System") },
        actions = {
            IconButton(onClick = component::onSettingsClick) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "settings",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
    )
}

@Composable
fun SignInToolbarUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        SignInToolbarUi(FakeSignInToolbarComponent())
    }
}

@Preview(name = "light")
@Composable
fun SignInToolbarUiPreviewLight(){
    SignInToolbarUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun SignInToolbarUiPreviewDark(){
    SignInToolbarUiPreview(darkTheme = true)
}