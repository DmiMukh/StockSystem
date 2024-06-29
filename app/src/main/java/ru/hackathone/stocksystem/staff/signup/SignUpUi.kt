package ru.hackathone.stocksystem.staff.signup

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
import androidx.compose.ui.unit.dp
import ru.hackathone.stocksystem.staff.list.toolbar.StaffListToolbarUi

@Composable
fun SignUpUi(component: SignUpComponent) {

    val fullName = component.fullName.collectAsState()
    val login = component.login.collectAsState()
    val password = component.password.collectAsState()
    val roleId = component.roleId.collectAsState()
    val roleName = component.roleName.collectAsState()

    Scaffold(
        topBar = { StaffListToolbarUi(component.toolbarComponent) }
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
        }
    }
}