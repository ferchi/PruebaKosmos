package com.example.android.roomwordssample.features.users.domain

import com.example.android.roomwordssample.features.users.data.source.remote.RetrofitHelper
import com.example.android.roomwordssample.features.users.data.source.remote.UsersClient
import com.example.android.roomwordssample.features.users.domain.model.User
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class UsersService {
    private val retrofit = RetrofitHelper.getRetrofit()
    suspend fun getUsers(): List<User> {
        return withContext(Dispatchers.IO) {
            val response = retrofit.create(UsersClient::class.java).getAllUser()
            response.body()?.users ?: emptyList()
        }
    }
}