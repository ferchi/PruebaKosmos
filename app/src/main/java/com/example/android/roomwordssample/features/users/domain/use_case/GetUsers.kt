package com.example.android.roomwordssample.features.users.domain.use_case

import com.example.android.roomwordssample.features.users.domain.model.User
import com.example.android.roomwordssample.features.users.domain.repository.UserRepositoryImpl

class GetUsers {
    private val repository = UserRepositoryImpl()
    suspend operator fun invoke():List<User>? = repository.getUsers()

}