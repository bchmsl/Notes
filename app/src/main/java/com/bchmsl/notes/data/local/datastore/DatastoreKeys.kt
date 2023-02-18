package com.bchmsl.notes.data.local.datastore

import androidx.datastore.preferences.core.stringPreferencesKey

object DatastoreKeys {
    const val DATASTORE_NAME = "username"
    val USERNAME_PREF_KEY = stringPreferencesKey("username_key")
}