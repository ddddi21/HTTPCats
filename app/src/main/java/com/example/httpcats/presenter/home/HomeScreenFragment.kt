package com.example.httpcats.presenter.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.*
import com.example.httpcats.databinding.HomePageFragmentBinding
import com.example.httpcats.domain.repository.WordRepository
import com.example.httpcats.presenter.apiActivity.ApiActivityVM
import com.example.httpcats.presenter.base.BaseFragment
import com.example.httpcats.presenter.base.MyMainApplication
import javax.inject.Inject

class HomeScreenFragment : BaseFragment<HomeScreenVM>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var homeVM: HomeScreenVM


    override fun onCreate(savedInstanceState: Bundle?) {
        MyMainApplication.appComponent.inject(this)
        homeVM = ViewModelProvider(this, viewModelFactory).get(HomeScreenVM::class.java)
        homeVM.randomSupport()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = HomePageFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = homeVM
        return binding.root

    }
}