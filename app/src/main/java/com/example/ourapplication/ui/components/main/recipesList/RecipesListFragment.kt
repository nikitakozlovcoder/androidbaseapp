package com.example.ourapplication.ui.components.main.recipesList

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.ourapplication.databinding.FragmentRecipesBinding
import com.example.ourapplication.ui.recyclers.ListItemsAdapter
import com.example.ourapplication.viewmodels.main.MainViewModel

class RecipesListFragment : Fragment() {


    private var _binding: FragmentRecipesBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainViewModel: MainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        _binding = FragmentRecipesBinding.inflate(inflater, container, false)

        mainViewModel.recipes.observe(viewLifecycleOwner){
            val adapter = ListItemsAdapter(it){ position ->
                mainViewModel.setSelected(position)
            }
            _binding?.recyclerView?.adapter = adapter
            _binding?.recyclerView?.layoutManager = LinearLayoutManager(requireContext())
        }

        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}