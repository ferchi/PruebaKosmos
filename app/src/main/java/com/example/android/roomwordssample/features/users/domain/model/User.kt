package com.example.android.roomwordssample.features.users.domain.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class User(
    @SerializedName("email") val email: String,
    @SerializedName("first_name") val name: String,
    @SerializedName("last_name") val lastName: String
)
