package com.example.ourapplication.viewmodels.login

import android.app.Application
import android.util.Log
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
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
    val incorrectPasswordVisibility = MutableLiveData(View.GONE)
    val incorrectEmailVisibility = MutableLiveData(View.GONE)
    val navChannel = Channel<Int>()

    fun onLogin(){
        email.value?.let {
            val user = userRepo.getUserByEmail(it)
            when {
                user == null -> {
                    incorrectEmailVisibility.value = View.VISIBLE
                }
                user.password == password.value -> {
                    viewModelScope.launch {
                        navChannel.send(R.id.action_loginFragment_to_mainFragment)
                    }
                }
                else -> {
                    incorrectPasswordVisibility.value = View.VISIBLE
                }
            }

        }
        Log.d("VM", "login")
    }

   fun onType(){
       incorrectPasswordVisibility.value = View.GONE
       incorrectEmailVisibility.value = View.GONE
   }
}