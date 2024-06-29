package ru.hackathone.stocksystem.product.details

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
import ru.hackathone.stocksystem.product.details.toolbar.ProductDetailsToolbarUi

@Composable
fun ProductDetailsUi(component: ProductDetailsComponent){

    val name = component.name.collectAsState()
    val description = component.description.collectAsState()
    val categoryName = component.categoryName.collectAsState()
    val locationRow = component.locationRow.collectAsState()
    val locationPlace = component.locationPlace.collectAsState()
    val statusName = component.statusName.collectAsState()

    Scaffold(
        topBar = { ProductDetailsToolbarUi(component.toolbarComponent) }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            OutlinedTextField(
                value = name.value,
                onValueChange = component::onNameChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Product Name") },
                supportingText = { Text(text = "Required field") },
                isError = name.value.isEmpty(),
                shape = CircleShape
            )

            OutlinedTextField(
                value = description.value,
                onValueChange = component::onDescriptionChange,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                label = { Text(text = "Description") },
                supportingText = { Text(text = "Required field") },
                isError = description.value.isEmpty(),
                shape = CircleShape
            )
        }
    }
}

@Composable
fun ProductDetailsUiPreview(darkTheme: Boolean){
    AppTheme(
        darkTheme = darkTheme
    ) {
        ProductDetailsUi(FakeProductDetailsComponent())
    }
}

@Preview(name = "light")
@Composable
fun ProductDetailsUiPreviewLight(){
    ProductDetailsUiPreview(darkTheme = false)
}

@Preview(name = "dark")
@Composable
fun ProductDetailsUiPreviewDark(){
    ProductDetailsUiPreview(darkTheme = true)
}