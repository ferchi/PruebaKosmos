package com.example.android.roomwordssample.features.users.domain.model

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class ResponseModel(
    @SerializedName("data") val users: List<User>
)
