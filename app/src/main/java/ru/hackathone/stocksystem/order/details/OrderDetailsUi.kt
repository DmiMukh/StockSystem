package ru.hackathone.stocksystem.order.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.core.utils.StaffRole
import ru.hackathone.stocksystem.order.details.toolbar.OrderDetailsToolbarUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderDetailsUi(component: OrderDetailsComponent) {

    val roleId = component.roleId.collectAsState()

    val title = component.title.collectAsState()
    val description = component.description.collectAsState()
    val statusId = component.statusId.collectAsState()
    val statusName = component.statusName.collectAsState()
    val userId = component.userId.collectAsState()
    val userName = component.userName.collectAsState()

    val statuses = component.statuses.collectAsState()
    val users = component.users.collectAsState()

    var isExpandedStatuses by remember {
        mutableStateOf(false)
    }

    var isExpandedUsers by remember {
        mutableStateOf(false)
    }

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

            ExposedDropdownMenuBox(
                expanded = isExpandedStatuses,
                onExpandedChange = { isExpandedStatuses = !isExpandedStatuses }
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    value = statusName.value,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedStatuses) }
                )
                
                ExposedDropdownMenu(
                    expanded = isExpandedStatuses,
                    onDismissRequest = { isExpandedStatuses = false }
                ) {
                    statuses.value.forEachIndexed { index, status ->
                        DropdownMenuItem(
                            text = { Text(text = status.name) },
                            onClick = {
                                (component::onStatusChange)(status)
                                isExpandedStatuses = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }

            if (roleId.value <= StaffRole.MANAGER.roleId) {
                ExposedDropdownMenuBox(
                    expanded = isExpandedUsers,
                    onExpandedChange = { isExpandedUsers = !isExpandedUsers }
                ) {
                    TextField(
                        modifier = Modifier.menuAnchor(),
                        value = userName.value,
                        onValueChange = {},
                        readOnly = true,
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedUsers) }
                    )

                    ExposedDropdownMenu(
                        expanded = isExpandedUsers,
                        onDismissRequest = { isExpandedUsers = false }
                    ) {
                        users.value.forEachIndexed { index, user ->
                            DropdownMenuItem(
                                text = { Text(text = user.fullName) },
                                onClick = {
                                    (component::onUserChange)(user)
                                    isExpandedUsers = false
                                },
                                contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                            )
                        }
                    }
                }
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