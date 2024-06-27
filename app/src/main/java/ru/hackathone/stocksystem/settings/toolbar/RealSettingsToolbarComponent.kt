package ru.hackathone.stocksystem.settings.toolbar

import com.arkivanov.decompose.ComponentContext

class RealSettingsToolbarComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onSave: () -> Unit
): ComponentContext by componentContext, SettingsToolbarComponent {
    override fun onBackClick() = this.onBack.invoke()

    override fun onSaveClick() = this.onSave.invoke()
}