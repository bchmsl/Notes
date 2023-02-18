package com.bchmsl.notes.presentation.add_note

import androidx.navigation.fragment.findNavController
import com.bchmsl.notes.databinding.FragmentAddNoteBinding
import com.bchmsl.notes.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddNoteFragment :  BaseFragment<FragmentAddNoteBinding>(FragmentAddNoteBinding::inflate) {
    override fun start() {
        listeners()
    }

    private fun listeners() {
        binding.btnDone.setOnClickListener {
            findNavController().popBackStack()
        }

        binding.btnDiscard.setOnClickListener {
            findNavController().popBackStack()
        }
    }

}