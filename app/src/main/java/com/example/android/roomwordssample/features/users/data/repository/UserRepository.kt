package com.example.android.roomwordssample.features.users.data.repository

import com.example.android.roomwordssample.features.users.domain.model.User

interface UserRepository {
    suspend fun getUsers(): List<User>
}