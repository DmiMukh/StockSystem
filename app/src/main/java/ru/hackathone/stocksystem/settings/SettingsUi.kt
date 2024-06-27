package ru.hackathone.stocksystem.settings

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.stocksystem.settings.toolbar.SettingsToolbarUi

@Composable
fun SettingsUi(component: SettingsComponent) {

    val authServiceHost = component.authServiceHost.collectAsState()
    val productServiceHost = component.productServiceHost.collectAsState()
    val staffServiceHost = component.staffServiceHost.collectAsState()

    Scaffold(
        topBar = { SettingsToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            OutlinedTextField(
                value = authServiceHost.value,
                onValueChange = component::onAuthServiceHostChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Auth Service Host") },
                supportingText = { Text(text = "Required field") },
                isError = authServiceHost.value.isEmpty(),
                shape = CircleShape
            )

            OutlinedTextField(
                value = productServiceHost.value,
                onValueChange = component::onProductServiceHostChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Product Service Host") },
                supportingText = { Text(text = "Required field") },
                isError = productServiceHost.value.isEmpty(),
                shape = CircleShape
            )

            OutlinedTextField(
                value = staffServiceHost.value,
                onValueChange = component::onStaffServiceHostChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Staff Service Host") },
                supportingText = { Text(text = "Required field") },
                isError = staffServiceHost.value.isEmpty(),
                shape = CircleShape
            )
        }
    }
}

@Composable
fun SettingsUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        SettingsUi(FakeSettingsComponent())
    }
}

@Preview(name = "light")
@Composable
fun SettingsUiPreviewLight(){
    SettingsUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun SettingsUiPreviewDark(){
    SettingsUiPreview(darkTheme = true)
}