package com.bchmsl.notes.data.repository

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import com.bchmsl.notes.data.local.datastore.DatastoreKeys
import com.bchmsl.notes.domain.repository.UsernameRepository
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class UsernameRepositoryImpl @Inject constructor(private val dataStore: DataStore<Preferences>) :
    UsernameRepository {

    override suspend fun getUsername(): String? {
        return dataStore.data.first()[DatastoreKeys.USERNAME_PREF_KEY]
    }

    override suspend fun saveUsername(username: String) {
        dataStore.edit {
            it[DatastoreKeys.USERNAME_PREF_KEY] = username
        }
    }
}