package com.example.ourapplication.viewmodels.login

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.ourapplication.R
import com.example.ourapplication.repos.UserRepo
import com.example.ourapplication.repos.contracts.IUserRepo
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.consumeAsFlow
import kotlinx.coroutines.launch


class LoginViewModel(application: Application) : AndroidViewModel(application) {
    private var userRepo: IUserRepo = UserRepo()
    val email = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val navChannel = Channel<Int>()

    fun onLogin(){
        email.value?.let {
            val user = userRepo.getUserByEmail(it)
            if(user?.password == password.value) {
                viewModelScope.launch {
                    navChannel.send(R.id.action_loginFragment_to_mainFragment)
                }
            }
        }
        Log.d("VM", "login")
    }
}