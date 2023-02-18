package com.bchmsl.notes.presentation.home

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.navArgs
import com.bchmsl.notes.databinding.FragmentHomeBinding
import com.bchmsl.notes.presentation.base.BaseFragment
import com.bchmsl.notes.presentation.home.adapter.NotesPageAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {

    private val notesPageAdapter by lazy { NotesPageAdapter(this) }
    private val vm: HomeViewModel by viewModels()
    private val args: HomeFragmentArgs by navArgs()
    override fun start() {
        setupViewPager()
        getUsername()
    }

    private fun setupViewPager() {
        binding.viewPager.adapter = notesPageAdapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = "OBJECT ${(position + 1)}"
        }.attach()
    }

    private fun getUsername() {
        binding.tvWelcome.text = "Welcome back,\n${args.username}!"
    }
}


