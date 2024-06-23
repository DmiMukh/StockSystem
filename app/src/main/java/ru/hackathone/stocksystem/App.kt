package ru.hackathone.stocksystem

import android.app.Application
import android.content.Context
import org.koin.core.Koin
import ru.hackathone.core.ComponentFactory
import ru.hackathone.core.KoinProvider

class App : Application(), KoinProvider {

    override lateinit var koin: Koin
        private set

    override fun onCreate() {
        super.onCreate()
        koin = createKoin()
    }

    private fun createKoin(): Koin {
        return Koin().apply {
            loadModules(allModules)
            declare(this@App as Application)
            declare(this@App as Context)
            declare(ComponentFactory(this))
            createEagerInstances()
        }
    }
}