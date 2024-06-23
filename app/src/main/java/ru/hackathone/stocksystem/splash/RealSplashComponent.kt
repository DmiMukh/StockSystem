package ru.hackathone.stocksystem.splash

import com.arkivanov.decompose.ComponentContext

class RealSplashComponent(
    componentContext: ComponentContext,
    private val onFinish: () -> Unit
) : ComponentContext by componentContext, SplashComponent {

    override val delayTime = 500

    override fun onFinish() = this.onFinish.invoke()
}