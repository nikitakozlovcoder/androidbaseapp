package com.example.ourapplication.repos

import android.content.Context
import com.example.ourapplication.R
import com.example.ourapplication.models.RecipeModel
import com.example.ourapplication.repos.contracts.IRecipeRepo

class RecipeRepo(context: Context) : IRecipeRepo {

    private val recipes: Array<RecipeModel> by lazy{
        val descriptions = context.resources.getStringArray(R.array.descriptions)
        val titles = context.resources.getStringArray(R.array.titles)
        val res = mutableListOf<RecipeModel>()
        for (i in titles.indices){
            res.add(RecipeModel(title = titles[i], description = descriptions.getOrNull(i)?:"" ))
        }
        res.toTypedArray()
    }
    override fun getAll(): Array<RecipeModel> {
            return recipes
    }
}