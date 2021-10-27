package com.example.ourapplication.viewmodels.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.ourapplication.R
import com.example.ourapplication.models.RecipeModel
import com.example.ourapplication.repos.RecipeRepo
import com.example.ourapplication.repos.contracts.IRecipeRepo
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val recipeRepo: IRecipeRepo = RecipeRepo(application.applicationContext)
    val recipes = liveData {
        emit(recipeRepo.getAll())
    }
    val choosedRecipe = MutableLiveData(recipeRepo.getAll().first())
    val navChannel = Channel<Int>()
    fun setSelected(position: Int){
        choosedRecipe.value = recipeRepo.getAll()[position]
        viewModelScope.launch {
            navChannel.send(R.id.action_navigation_recipes_list_to_navigation_recipe_item)
        }
    }
}