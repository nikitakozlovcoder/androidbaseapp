package com.example.ourapplication.ui.components.main.recipeItem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.ourapplication.databinding.FragmentRecipeBinding
import com.example.ourapplication.viewmodels.main.MainViewModel

class RecipeItemFragment : Fragment() {


    private var _binding: FragmentRecipeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mainViewModel: MainViewModel = ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

        _binding = FragmentRecipeBinding.inflate(inflater, container, false)
        _binding?.viewModel = mainViewModel
        _binding?.lifecycleOwner = viewLifecycleOwner
        /* mainViewModel.o.observe(viewLifecycleOwner, Observer {
            textView.text = it
        })*/
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}