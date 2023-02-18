package com.bchmsl.notes.presentation.welcome

import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.bchmsl.notes.common.extensions.async
import com.bchmsl.notes.databinding.FragmentWelcomeBinding
import com.bchmsl.notes.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main

@AndroidEntryPoint
class WelcomeFragment : BaseFragment<FragmentWelcomeBinding>(FragmentWelcomeBinding::inflate) {
    private val vm: WelcomeViewModel by viewModels()
    private var username = ""
    override fun start() {
        checkIfFirstOpen()
    }

    private fun goToHome() {
        async(Main) {
            findNavController().navigate(
                WelcomeFragmentDirections.actionWelcomeFragmentToHomeFragment(
                    username
                )
            )
        }
    }

    private fun listeners() {
        binding.btnDone.setOnClickListener {
            username = binding.etName.text.toString()
            vm.saveUsername(username)
            goToHome()
        }
    }


    private fun checkUsername() {
        binding.etName.doOnTextChanged { text, _, _, _ ->
            binding.btnDone.isEnabled = text?.isNotBlank() == true
        }
        listeners()
    }

    private fun checkIfFirstOpen() {
        vm.getUsername()
        async(IO) {
            vm.usernameState.collect { user ->
                if (user == null) {
                    checkUsername()
                } else {
                    username = user
                    goToHome()
                }

            }
        }
    }
}