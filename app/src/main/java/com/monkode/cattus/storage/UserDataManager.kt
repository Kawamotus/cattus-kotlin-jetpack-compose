package com.monkode.cattus.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.monkode.cattus.api.models.UserData
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore("userdata_prefs")

class UserDataManager(private val context: Context) {
    companion object{
        private val USER_ID = stringPreferencesKey("user_id")
        private val USER_NAME = stringPreferencesKey("user_name")
        private val USER_PICTURE = stringPreferencesKey("user_picture")
        private val USER_ACCESS_LEVEL = stringPreferencesKey("user_access_level")
        private val USER_COMPANY = stringPreferencesKey("user_company")
    }

    suspend fun saveUserData(id: String, name: String, picture: String, accessLevel: String, company: String){
        context.dataStore.edit { prefs ->
            prefs[USER_ID] = id 
            prefs[USER_NAME] = name
            prefs[USER_PICTURE] = picture
            prefs[USER_ACCESS_LEVEL] = accessLevel
            prefs[USER_COMPANY] = company
        }
    }

    suspend fun getUserData(): UserData {
        return context.dataStore.data.map { prefs ->
            UserData(
                id = prefs[USER_ID],
                name = prefs[USER_NAME],
                picture = prefs[USER_PICTURE],
                accessLevel = prefs[USER_ACCESS_LEVEL],
                company = prefs[USER_COMPANY]
            )
        }.first()
    }

    suspend fun getCompany(): String? {
        return context.dataStore.data.map { prefs ->
            prefs[USER_COMPANY]
        }.first()
    }

    suspend fun clearUserData() {
        context.dataStore.edit { prefs ->
            prefs.remove(USER_ID)
            prefs.remove(USER_NAME)
            prefs.remove(USER_PICTURE)
            prefs.remove(USER_ACCESS_LEVEL)
            prefs.remove(USER_COMPANY)
        }
    }
}