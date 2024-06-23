package ru.hackathone.core.message.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Popup
import androidx.compose.ui.window.PopupProperties
import androidx.compose.runtime.getValue
import ru.hackathone.core.message.domain.Message
import ru.hackathone.core.theme.AppTheme


/**
 * Displays a [Message] as a popup at the bottom of screen.
 */
@Composable
fun MessageUi(
    component: MessageComponent,
    modifier: Modifier = Modifier,
    bottomPadding: Dp
) {
    val visibleMessage by component.visibleMessage.collectAsState()
    val additionalBottomPadding = with(LocalDensity.current) {
        LocalMessageOffsets.current.values.maxOrNull()?.toDp() ?: 0.dp
    }
    Box(modifier = modifier.fillMaxSize()) {
        visibleMessage?.let {/*
            val inverseIsDarkTheme = MaterialTheme.colors.isLight
            AppTheme(inverseIsDarkTheme) {*/
            MessagePopup(
                message = it,
                bottomPadding = bottomPadding + additionalBottomPadding,
                onAction = component::onActionClick
            )
            //}
        }
    }
}

@Composable
private fun MessagePopup(
    message: Message,
    onAction: () -> Unit,
    bottomPadding: Dp
) {
    Popup(
        alignment = Alignment.BottomCenter,
        properties = PopupProperties(
            dismissOnBackPress = false,
            dismissOnClickOutside = false
        )
    ) {
        Card(
            shape = RoundedCornerShape(8.dp),
            modifier = Modifier
                .padding(bottom = bottomPadding, start = 8.dp, end = 8.dp)
                .wrapContentSize()
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier
                    .padding(vertical = 13.dp, horizontal = 16.dp)
                    .fillMaxWidth()
            ) {
                message.iconRes?.let {
                    Icon(
                        painter = painterResource(it),
                        contentDescription = null
                    )
                }
                Text(
                    modifier = Modifier.weight(1f),
                    text = message.text,
                )
                message.actionTitle?.let {
                    MessageButton(text = it, onClick = onAction)
                }
            }
        }
    }
}

@Composable
private fun MessageButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    TextButton(
        onClick = onClick,
        modifier = modifier,
    ) {
        Text(
            text = text
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun MessageUiPreview() {
    AppTheme {
        MessageUi(FakeMessageComponent(), Modifier, 40.dp)
    }
}