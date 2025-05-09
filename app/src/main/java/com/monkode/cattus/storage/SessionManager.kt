package com.monkode.cattus.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.auth0.android.jwt.JWT
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import java.util.Date

private val Context.dataStore by preferencesDataStore("auth_prefs")

class SessionManager(private val context: Context) {
    companion object {
        private val TOKEN_KEY = stringPreferencesKey("auth_token")
    }

    suspend fun saveToken(token: String){
        context.dataStore.edit { prefs ->
            prefs[TOKEN_KEY] = token
        }
    }

    suspend fun getToken(): String? {
        return context.dataStore.data.map { prefs ->
            prefs[TOKEN_KEY]
        }.first()
    }

    suspend fun clearToken() {
        context.dataStore.edit {prefs ->
            prefs.remove(TOKEN_KEY)
        }
    }

    suspend fun isValidToken(): Boolean {
        val token = getToken() ?: return false
        return try {
            val jwt = JWT(token)
            jwt.expiresAt?.after(Date()) == true
        } catch (e: Exception) {
            false
        }
    }
}


