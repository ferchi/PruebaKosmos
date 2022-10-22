package com.example.android.roomwordssample.features.users.domain

import com.example.android.roomwordssample.features.users.domain.model.User

class UserProvider {
    companion object {
        var users:List<User> = emptyList()
    }
}