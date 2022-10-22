package com.example.android.roomwordssample.features.users.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android.roomwordssample.features.users.domain.model.User
import com.example.android.roomwordssample.features.users.domain.use_case.GetUsers
import kotlinx.coroutines.launch


class UsersViewModel : ViewModel() {

    val user = MutableLiveData<User>()

    var getUsers = GetUsers()

    fun onCreate() {
        viewModelScope.launch {
            val result = getUsers()

            if(!result.isNullOrEmpty()){
                user.postValue(result[0])
            }
        }
    }

}