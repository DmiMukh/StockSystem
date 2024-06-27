package ru.hackathone.core.storage

import android.content.Context

class SettingsStorageImpl(private val context: Context) : SettingsStorage {
    private val SHARED_PREFERENCES_NAME = "app_settings"
    private val sharedPreferences =
        this.context.getSharedPreferences(SHARED_PREFERENCES_NAME, Context.MODE_PRIVATE)

    override fun putString(key: String, param: String) =
        sharedPreferences.edit().putString(key, param).commit()

    override fun putInt(key: String, param: Int) =
        sharedPreferences.edit().putInt(key, param).commit()

    override fun putLong(key: String, param: Long) =
        sharedPreferences.edit().putLong(key, param).commit()

    override fun putFloat(key: String, param: Float) =
        sharedPreferences.edit().putFloat(key, param).commit()

    override fun putBoolean(key: String, param: Boolean) =
        sharedPreferences.edit().putBoolean(key, param).commit()

    override fun getString(key: String) = sharedPreferences.getString(key, "") ?: ""
    override fun getInt(key: String) = sharedPreferences.getInt(key, 0)
    override fun getLong(key: String) = sharedPreferences.getLong(key, 0)
    override fun getFloat(key: String) = sharedPreferences.getFloat(key, 0.toFloat())
    override fun getBoolean(key: String) = sharedPreferences.getBoolean(key, false)
}