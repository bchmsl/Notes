package com.bchmsl.notes.domain.repository

interface UsernameRepository {
    suspend fun getUsername(): String?
    suspend fun saveUsername(username: String)
}