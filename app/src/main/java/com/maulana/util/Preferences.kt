package com.maulana.util

import android.content.SharedPreferences
import androidx.core.content.edit

private const val PREF_TOKEN = "token"

operator fun SharedPreferences.set(key: String, value: Any?) {
    when (value) {
        is String? -> edit { putString(key, value) }
        is Int -> edit { putInt(key, value) }
        is Boolean -> edit { putBoolean(key, value) }
        is Float -> edit { putFloat(key, value) }
        is Long -> edit { putLong(key, value) }
        is HashSet<*> -> edit { putStringSet(key, value as MutableSet<String>?) }
        else -> throw UnsupportedOperationException("Pref factory set not yet implemented")
    }
}

inline operator fun <reified T : Any?> SharedPreferences.get(
    key: String,
    defaultValue: T? = null
): T? =
    when (T::class) {
        String::class -> getString(key, defaultValue as? String ?: "") as? T?
        Int::class -> getInt(key, defaultValue as? Int ?: -1) as? T?
        Boolean::class -> getBoolean(key, defaultValue as? Boolean ?: false) as? T?
        Float::class -> getFloat(key, defaultValue as? Float ?: -1F) as? T?
        Long::class -> getLong(key, defaultValue as? Long ?: -1L) as? T?
        HashSet::class -> getStringSet(
            key,
            defaultValue as? HashSet<String> ?: hashSetOf<String>()
        ) as? T?

        else -> throw UnsupportedOperationException("Pref factory get not yet implemented")
    }

fun SharedPreferences.saveToken(token: String) {
    set(PREF_TOKEN, token)
}

fun SharedPreferences.loadToken(): String? = get(PREF_TOKEN)