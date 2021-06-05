package com.example.httpcats.presenter.joke

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.httpcats.databinding.JokesFragmentBinding
import com.example.httpcats.presenter.base.BaseFragment
import com.example.httpcats.presenter.base.MyMainApplication
import javax.inject.Inject

class JokesFragment : BaseFragment<JokesVM>() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var jokesVM: JokesVM
    lateinit var binding: JokesFragmentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        MyMainApplication.appComponent.inject(this)
        jokesVM = ViewModelProvider(this, viewModelFactory).get(JokesVM::class.java)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = JokesFragmentBinding.inflate(inflater, container, false)
        binding.apply {
            vm = jokesVM
            lifecycleOwner = this@JokesFragment
            rvTasksList.apply {
                layoutManager = LinearLayoutManager(requireContext())
                adapter = jokesVM.jokeAdapter
                addItemDecoration(DividerItemDecoration(context, RecyclerView.VERTICAL))
            }
            progressBar.visibility = View.VISIBLE
        }

        val actionName = arguments?.getString("actionName")
        if (!actionName.isNullOrEmpty()){
            when(actionName) {
//                "random" -> jokesVM.loadRandomJoke()
                "randomTen" -> jokesVM.loadTenJoke()
//                "randomIt" -> jokesVM.loadITJoke()
                "randomItTen" -> jokesVM.loadTenItJoke()
                else -> jokesVM.loadTenJoke()
            }
        } else jokesVM.loadTenJoke()

        jokesVM.jokesList.observe(viewLifecycleOwner) { list ->
                jokesVM.jokeAdapter.updateDataSource(list)
            binding.progressBar.visibility = View.GONE
        }

        binding.swipe.setOnRefreshListener {
                binding.swipe.isRefreshing = false
                jokesVM.loadTenJoke()
                jokesVM.jokesList.observe(viewLifecycleOwner) {
                    jokesVM.jokeAdapter.updateDataSource(it)
                    binding.progressBar.visibility = View.GONE
                }
            binding.progressBar.visibility = View.VISIBLE
        }
        return binding.root
    }
}