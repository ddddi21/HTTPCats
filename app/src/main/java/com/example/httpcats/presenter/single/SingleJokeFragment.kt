package com.example.httpcats.presenter.single

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.httpcats.databinding.HomePageFragmentBinding
import com.example.httpcats.databinding.SingleJokeFragmentBinding
import com.example.httpcats.presenter.apiActivity.ApiActivityVM
import com.example.httpcats.presenter.base.BaseFragment
import com.example.httpcats.presenter.base.MyMainApplication
import com.example.httpcats.presenter.home.HomeScreenVM
import javax.inject.Inject

class SingleJokeFragment(): BaseFragment<SingleJokeVm>() {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var singleJokeVM: SingleJokeVm

    override fun onCreate(savedInstanceState: Bundle?) {
        MyMainApplication.appComponent.inject(this)
        singleJokeVM = ViewModelProvider(this, viewModelFactory).get(SingleJokeVm::class.java)
        singleJokeVM.loadRandom()
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = SingleJokeFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = singleJokeVM
        binding.swipe.setOnRefreshListener {
            binding.swipe.isRefreshing = false
            singleJokeVM.loadRandom()
            binding.progressBar.visibility = View.VISIBLE
        }
        return binding.root
    }
}