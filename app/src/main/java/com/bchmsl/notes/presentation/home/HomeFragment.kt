package com.bchmsl.notes.presentation.home

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bchmsl.notes.common.extensions.async
import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.databinding.FragmentHomeBinding
import com.bchmsl.notes.presentation.base.BaseFragment
import com.bchmsl.notes.presentation.home.adapter.NotesPageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.Main

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private lateinit var notesPageAdapter: NotesPageAdapter
    private val vm: HomeViewModel by viewModels()
    private val args: HomeFragmentArgs by navArgs()
    override fun start() {
        async(Main) {
            observe()
            getUsername()
            listeners()
        }
    }

    private fun observe() {
        async(Main) {
            vm.categoriesState.collect {
                setupViewPager(it)
            }
        }
    }

    private fun listeners() {
        binding.fabAdd.setOnClickListener {
            goToAddNote()
        }
    }

    private fun goToAddNote() {
        findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAddNoteFragment())
    }

    private fun setupViewPager(categories: List<Category>) {
        notesPageAdapter = NotesPageAdapter(this@HomeFragment, categories)
        binding.viewPager.adapter = notesPageAdapter
        setupTabLayout(categories)
    }

    private fun setupTabLayout(categories: List<Category>) {
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = categories[position].categoryName
        }.attach()
    }

    private fun getUsername() {
        "Welcome back,\n${args.username}!".also { binding.tvWelcome.text = it }
    }
}


