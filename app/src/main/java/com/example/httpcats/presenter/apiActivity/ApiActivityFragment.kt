package com.example.httpcats.presenter.apiActivity

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.httpcats.databinding.ApiActivityFragmentBinding
import com.example.httpcats.presenter.base.BaseFragment
import com.example.httpcats.presenter.base.MyMainApplication
import javax.inject.Inject


class ApiActivityFragment : BaseFragment<ApiActivityVM>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var apiActitvityVM: ApiActivityVM

    override fun onCreate(savedInstanceState: Bundle?) {
        MyMainApplication.appComponent.inject(this)
        apiActitvityVM = ViewModelProvider(this, viewModelFactory).get(ApiActivityVM::class.java)
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = ApiActivityFragmentBinding.inflate(inflater, container, false)
        binding.lifecycleOwner = this
        binding.vm = apiActitvityVM
        apiActitvityVM.isHasLink.observe(viewLifecycleOwner) {
            if (apiActitvityVM.isHasLink.value == false) {
                binding.tvActivityLink.visibility = View.GONE
            } else {
                binding.tvActivityLink.visibility = View.VISIBLE
            }
        }
        apiActitvityVM.letsFun()
        binding.btnAgain.setOnClickListener {
            apiActitvityVM.letsFun()
        }

        return binding.root
    }
}