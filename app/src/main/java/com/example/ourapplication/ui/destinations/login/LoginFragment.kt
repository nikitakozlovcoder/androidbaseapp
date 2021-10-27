package com.example.ourapplication.ui.destinations.login

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import com.example.ourapplication.databinding.LoginFragmentBinding
import com.example.ourapplication.ui.activities.contracts.INavigatableActivity
import com.example.ourapplication.viewmodels.login.LoginViewModel

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }
    private lateinit var navCallback: INavigatableActivity
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    override fun onAttach(context: Context) {
        super.onAttach(context)
        navCallback = context as INavigatableActivity
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        viewLifecycleOwner.lifecycleScope.launchWhenResumed {
            for(event in viewModel.navChannel){
                navCallback.navigateTo(event)
            }
        }

        return binding.root
    }
}