package com.example.ourapplication.ui.recyclers

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.example.ourapplication.BR
import com.example.ourapplication.databinding.ItemLayoutBinding
import com.example.ourapplication.models.RecipeModel

class ListItemsAdapter(private val dataSet: Array<RecipeModel>, private val callback: ((position: Int)->Unit)?) : RecyclerView.Adapter<ListItemsAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemLayoutBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.binding.recipe = dataSet[position]
       holder.binding.root.setOnClickListener {
            callback?.invoke(position)
        }
    }

    override fun getItemCount(): Int = dataSet.size
}