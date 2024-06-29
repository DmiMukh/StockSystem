package ru.hackathone.stocksystem.order.details

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
import ru.hackathone.core.utils.StaffRole
import ru.hackathone.stocksystem.order.details.toolbar.OrderDetailsToolbarUi

@Composable
fun OrderDetailsUi(component: OrderDetailsComponent) {

    val roleId = component.roleId.collectAsState()

    val title = component.title.collectAsState()
    val description = component.description.collectAsState()

    Scaffold(
        topBar = { OrderDetailsToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            OutlinedTextField(
                value = title.value,
                onValueChange = component::onTitleChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                enabled = (roleId.value <= StaffRole.MANAGER.roleId),
                label = { Text(text = "Title") },
                supportingText = { Text(text = "Required field") },
                isError = title.value.isEmpty(),
                shape = CircleShape
            )

            OutlinedTextField(
                value = description.value,
                onValueChange = component::onDescriptionChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                enabled = (roleId.value <= StaffRole.MANAGER.roleId),
                label = { Text(text = "Description") },
                supportingText = { Text(text = "Option field") },
                shape = CircleShape
            )

            // Task Status

            if (roleId.value <= StaffRole.MANAGER.roleId) {
                // Set User
            }
        }
    }
}

@Composable
fun OrderDetailsUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        OrderDetailsUi(FakeOrderDetailsComponent())
    }
}

@Preview(name = "light")
@Composable
fun OrderDetailsUiPreviewLight(){
    OrderDetailsUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun OrderDetailsUiPreviewDark(){
    OrderDetailsUiPreview(darkTheme = true)
}