package ru.hackathone.stocksystem.staff.signup

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
import androidx.compose.ui.unit.dp
import ru.hackathone.stocksystem.staff.list.toolbar.StaffListToolbarUi
import ru.hackathone.stocksystem.staff.signup.toolbar.SignUpToolbarUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpUi(component: SignUpComponent) {

    val fullName = component.fullName.collectAsState()
    val login = component.login.collectAsState()
    val password = component.password.collectAsState()
    val roleId = component.roleId.collectAsState()
    val roleName = component.roleName.collectAsState()
    val roles = component.roles.collectAsState()

    var isExpandedRoles by remember {
        mutableStateOf(false)
    }

    Scaffold(
        topBar = { SignUpToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            OutlinedTextField(
                value = fullName.value,
                onValueChange = component::onFullNameChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Staff FullName") },
                supportingText = { Text(text = "Required field") },
                isError = fullName.value.isEmpty(),
                shape = CircleShape
            )

            OutlinedTextField(
                value = login.value,
                onValueChange = component::onLoginChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Login") },
                supportingText = { Text(text = "Required field") },
                shape = CircleShape
            )

            OutlinedTextField(
                value = password.value,
                onValueChange = component::onPasswordChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Password") },
                supportingText = { Text(text = "Required field") },
                shape = CircleShape
            )

            ExposedDropdownMenuBox(
                expanded = isExpandedRoles,
                onExpandedChange = { isExpandedRoles = !isExpandedRoles }
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    value = roleName.value,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedRoles) }
                )

                ExposedDropdownMenu(
                    expanded = isExpandedRoles,
                    onDismissRequest = { isExpandedRoles = false }
                ) {
                    roles.value.forEachIndexed { index, item ->
                        DropdownMenuItem(
                            text = { Text(text = item.second) },
                            onClick = {
                                (component::onRoleChange)(item)
                                isExpandedRoles = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }
        }
    }
}