package com.example.android.roomwordssample.features.users.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.example.android.roomwordssample.R
import com.example.android.roomwordssample.features.users.domain.use_case.GetUsers

class UserActivity : AppCompatActivity() {
    private val userViewModel: UsersViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        userViewModel.onCreate()

        userViewModel.user.observe(this, Observer {

        })

    }
}