package com.example.httpcats.presenter.base

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.navigation.fragment.NavHostFragment


abstract class BaseFragment<T : ViewModel> : Fragment() {
    lateinit var viewModel: T
}

val Fragment.navigationController
    get() = NavHostFragment.findNavController(this)

