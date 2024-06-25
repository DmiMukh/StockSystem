package ru.hackathone.stocksystem.signin

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.Dispatchers
import ru.hackathone.core.theme.AppTheme
import ru.hackathone.stocksystem.R

@Composable
fun SignInUi(component: SignInComponent) {

    val login = component.login.collectAsState(Dispatchers.Main.immediate)
    val password = component.password.collectAsState(Dispatchers.Main.immediate)
    val inProgress = component.inProgress.collectAsState()

    val passwordVisibility = component.passwordVisibility.collectAsState()

    val icon = if (passwordVisibility.value)
        painterResource(id = R.drawable.ic_visibility_on)
    else
        painterResource(id = R.drawable.ic_visibility_off)

    Column {
        TextField(
            value = login.value,
            onValueChange = component::onLoginChanged
        )

        Row(){
            TextField(
                value = password.value,
                onValueChange = component::onPasswordChanged,
                visualTransformation = if (passwordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                trailingIcon = {
                    IconButton(onClick = { (component::onVisibilityChanged)(!passwordVisibility.value) }) {
                        Icon(
                            painter = icon,
                            contentDescription = "visibility",
                            modifier = Modifier.size(32.dp)
                        )
                    }
                }
            )
        }

        if (inProgress.value) {
            CircularProgressIndicator()
        } else {
            Button(
                onClick = component::onSignInClick
            ) {
                Text(text = "Войти")
            }
        }
    }
}

@Composable
fun SignInUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        SignInUi(FakeSignInComponent())
    }
}

@Preview(name = "light")
@Composable
fun SignInUiPreviewLight(){
    SignInUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun SignInUiPreviewDark(){
    SignInUiPreview(darkTheme = true)
}