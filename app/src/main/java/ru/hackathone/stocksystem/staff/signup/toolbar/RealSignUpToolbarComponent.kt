package ru.hackathone.stocksystem.staff.signup.toolbar

import com.arkivanov.decompose.ComponentContext

class RealSignUpToolbarComponent(
    componentContext: ComponentContext,
    private val onBack: () -> Unit,
    private val onSave: () -> Unit
): ComponentContext by componentContext, SignUpToolbarComponent {
    override fun onBackClick() = this.onBack.invoke()

    override fun onSaveClick() = this.onSave.invoke()
}