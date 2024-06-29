package ru.hackathone.stocksystem.product.details

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
import ru.hackathone.stocksystem.product.details.toolbar.ProductDetailsToolbarUi

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductDetailsUi(component: ProductDetailsComponent){

    val name = component.name.collectAsState()
    val description = component.description.collectAsState()
    val categoryName = component.categoryName.collectAsState()
    val locationRow = component.locationRow.collectAsState()
    val locationPlace = component.locationPlace.collectAsState()
    val statusName = component.statusName.collectAsState()

    val categories = component.categories.collectAsState()
    val locations = component.locations.collectAsState()
    val statuses = component.statuses.collectAsState()

    var isExpandedCategories by remember {
        mutableStateOf(false)
    }

    var isExpandedLocations by remember {
        mutableStateOf(false)
    }

    var isExpandedStatuses by remember {
        mutableStateOf(false)
    }

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

            // Category
            ExposedDropdownMenuBox(
                expanded = isExpandedCategories,
                onExpandedChange = { isExpandedCategories = !isExpandedCategories }
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    value = categoryName.value,
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedCategories) }
                )

                ExposedDropdownMenu(
                    expanded = isExpandedCategories,
                    onDismissRequest = { isExpandedCategories = false }
                ) {
                    categories.value.forEachIndexed { index, category ->
                        DropdownMenuItem(
                            text = { Text(text = category.name) },
                            onClick = {
                                (component::onCategoryChange)(category)
                                isExpandedCategories = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }

            // Location
            ExposedDropdownMenuBox(
                expanded = isExpandedLocations,
                onExpandedChange = { isExpandedLocations = !isExpandedLocations }
            ) {
                TextField(
                    modifier = Modifier.menuAnchor(),
                    value = locationRow.value.plus(" ").plus(locationPlace.value),
                    onValueChange = {},
                    readOnly = true,
                    trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpandedLocations) }
                )

                ExposedDropdownMenu(
                    expanded = isExpandedLocations,
                    onDismissRequest = { isExpandedLocations = false }
                ) {
                    locations.value.forEachIndexed { index, location ->
                        DropdownMenuItem(
                            text = { Text(text = location.place.plus(" ").plus(location.row)) },
                            onClick = {
                                (component::onLocationChange)(location)
                                isExpandedLocations = false
                            },
                            contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                        )
                    }
                }
            }

            // Status
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