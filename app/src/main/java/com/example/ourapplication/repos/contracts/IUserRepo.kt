package com.example.ourapplication.repos.contracts

import com.example.ourapplication.models.UserModel

interface IUserRepo {
    fun getUserByEmail(email: String): UserModel?
}