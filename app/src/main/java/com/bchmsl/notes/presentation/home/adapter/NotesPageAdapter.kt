package com.bchmsl.notes.presentation.home.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.bchmsl.notes.data.local.model.Category
import com.bchmsl.notes.presentation.home.notes.NotesFragment

class NotesPageAdapter(fragment: Fragment, private val categories: List<Category>) : FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int = categories.size
    override fun createFragment(position: Int): Fragment {
        val fragment = NotesFragment()
        fragment.arguments?.putString("categoryName", categories[position].categoryName)
        return fragment
    }
}
