package ru.hackathone.stocksystem.staff.signup.toolbar

import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import ru.hackathone.core.utils.ICON_SIZE

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpToolbarUi(component: SignUpToolbarComponent) {
    TopAppBar(
        title = { Text(text = "Sign Up") },
        navigationIcon = {
            IconButton(onClick = component::onBackClick) {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "arrow_back",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        },
        actions = {
            IconButton(onClick = component::onSaveClick) {
                Icon(
                    imageVector = Icons.Default.Refresh,
                    contentDescription = "save",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
    )
}