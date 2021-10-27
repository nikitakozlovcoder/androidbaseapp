package com.example.ourapplication.repos

import com.example.ourapplication.models.UserModel
import com.example.ourapplication.repos.contracts.IUserRepo

class UserRepo: IUserRepo {
    private val userStore = arrayOf(UserModel(email = "dave@m.com", password = "1"), UserModel(email = "jo@m.com", password = "12"), UserModel(email = "2@m.com", password = "123"), UserModel(email = "1", password = "1"))
    override fun getUserByEmail(email: String): UserModel? {
        return userStore.firstOrNull { it.email == email }
    }

}