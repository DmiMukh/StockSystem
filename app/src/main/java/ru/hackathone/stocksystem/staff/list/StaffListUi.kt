package ru.hackathone.stocksystem.staff.list

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.hackathone.core.utils.ICON_SIZE
import ru.hackathone.stocksystem.order.list.OrderListNoItems
import ru.hackathone.stocksystem.order.list.OrderListState
import ru.hackathone.stocksystem.order.list.item.OrderItem
import ru.hackathone.stocksystem.staff.list.item.StaffListItem
import ru.hackathone.stocksystem.staff.list.toolbar.StaffListToolbarUi

@Composable
fun StaffListUi(component: StaffListComponent) {

    val viewState = component.viewState.collectAsState()

    Scaffold(
        topBar = { StaffListToolbarUi(component.toolbarComponent) },
        floatingActionButton = {
            IconButton(
                onClick = component::onAddStaffClick
            ) {
                Icon(
                    imageVector = Icons.Default.AddCircle,
                    contentDescription = "add_staff",
                    modifier = Modifier.size(ICON_SIZE)
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {
            when(val state = viewState.value) {
                is StaffListState.Display -> {
                    LazyColumn(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        state.items.forEach { model ->
                            item {
                                StaffListItem(
                                    model = model,
                                    onClick = {  }
                                )
                            }
                        }
                    }
                }
                StaffListState.Loading -> CircularProgressIndicator(
                    modifier = Modifier.align(Alignment.Center)
                )
                StaffListState.NoItems -> OrderListNoItems(modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.Center)
                )
                StaffListState.Idle -> {}
            }
        }
    }
}