package com.bchmsl.notes.presentation.home.notes

import androidx.fragment.app.viewModels
import com.bchmsl.notes.common.extensions.async
import com.bchmsl.notes.data.local.model.Note
import com.bchmsl.notes.databinding.FragmentNotesBinding
import com.bchmsl.notes.presentation.base.BaseFragment
import com.bchmsl.notes.presentation.home.notes.adapter.NotesAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

@AndroidEntryPoint
class NotesFragment : BaseFragment<FragmentNotesBinding>(FragmentNotesBinding::inflate) {
    private val category by lazy { arguments?.getString("categoryName") }
    private val vm: NotesViewModel by viewModels()
    private val notesAdapter by lazy { NotesAdapter() }
    override fun start() {
        vm.getNotesByCategory(category ?: "")
        async(Main) {
            observe()
        }
    }

    private fun observe() {
        async(IO) {
            vm.notesState.collect {
                setupRecycler(it)
            }
        }
    }

    private fun setupRecycler(notes: List<Note>) {
        binding.rvNotes.adapter = notesAdapter
        notesAdapter.submitList(notes.toList())
    }
}