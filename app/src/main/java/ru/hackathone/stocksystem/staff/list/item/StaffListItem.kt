package ru.hackathone.stocksystem.staff.list.item

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.hackathone.core.inventoryApi.staff.models.Staff

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun StaffListItem(
    model: Staff,
    onClick: (Staff) -> Unit
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)
            .combinedClickable(
                onClick = { onClick(model) },
            ),
    ) {
        Column {
            Text(text = model.fullName)
        }
    }
}