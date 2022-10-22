package com.example.android.roomwordssample.features.users.domain.repository

import com.example.android.roomwordssample.features.users.data.repository.UserRepository
import com.example.android.roomwordssample.features.users.domain.UserProvider
import com.example.android.roomwordssample.features.users.domain.UsersService
import com.example.android.roomwordssample.features.users.domain.model.User

class UserRepositoryImpl: UserRepository {
    private val api = UsersService()
    override suspend fun getUsers():List<User>{
        val response = api.getUsers()
        UserProvider.users = response
        return response
    }
}