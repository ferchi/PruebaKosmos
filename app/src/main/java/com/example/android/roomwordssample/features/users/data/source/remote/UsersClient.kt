package com.example.android.roomwordssample.features.users.data.source.remote

import com.example.android.roomwordssample.features.users.domain.model.ResponseModel
import retrofit2.Response
import retrofit2.http.GET

interface UsersClient {
    @GET("/users?page=0")
    suspend fun getAllUser(): Response<ResponseModel>
}