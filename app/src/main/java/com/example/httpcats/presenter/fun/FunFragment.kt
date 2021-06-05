package com.example.httpcats.presenter.`fun`

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.httpcats.R
import com.example.httpcats.databinding.FunFragmentBinding
import com.example.httpcats.presenter.apiActivity.ApiActivityVM
import com.example.httpcats.presenter.base.BaseFragment
import com.example.httpcats.presenter.base.navigationController
import javax.inject.Inject

class FunFragment:BaseFragment<FunVM>() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FunFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        val bundle = Bundle()

        binding.btnFunRandomTenJoke.setOnClickListener {
            bundle.putString("actionName", "randomTen")
            navigationController.navigate(R.id.action_funFragment_to_jokesFragment, bundle)
        }
        binding.btnFunRandomTenItJoke.setOnClickListener {
            bundle.putString("actionName", "randomItTen")
            navigationController.navigate(R.id.action_funFragment_to_jokesFragment, bundle)
        }
        return binding.root
    }
}