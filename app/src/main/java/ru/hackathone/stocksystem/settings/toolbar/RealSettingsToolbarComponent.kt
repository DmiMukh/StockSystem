package ru.hackathone.stocksystem.settings.toolbar

import com.arkivanov.decompose.ComponentContext

class RealSettingsToolbarComponent(
    componentContext: ComponentContext,
    private val onSave: () -> Unit
): ComponentContext by componentContext, SettingsToolbarComponent {
    override fun onSaveClick() = this.onSave.invoke()
}