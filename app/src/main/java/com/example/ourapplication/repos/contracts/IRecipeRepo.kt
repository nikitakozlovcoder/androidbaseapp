package com.example.ourapplication.repos.contracts

import com.example.ourapplication.models.RecipeModel

interface IRecipeRepo {
    fun getAll(): Array<RecipeModel>
}