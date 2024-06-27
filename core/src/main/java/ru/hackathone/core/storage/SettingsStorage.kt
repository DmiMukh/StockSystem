package ru.hackathone.core.storage

interface SettingsStorage {
    fun putString(key: String, param: String): Boolean
    fun putInt(key: String, param: Int): Boolean
    fun putLong(key: String, param: Long): Boolean
    fun putFloat(key: String, param: Float): Boolean
    fun putBoolean(key: String, param: Boolean): Boolean

    fun getString(key: String): String
    fun getInt(key: String): Int
    fun getLong(key: String): Long
    fun getFloat(key: String): Float
    fun getBoolean(key: String): Boolean
}