package com.shahin.login.ui.fragments.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.shahin.login.databinding.FragmentLoginBinding
import com.shahin.login.extensions.simpleInputWatcher
import com.shahin.login.ui.fragments.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class LoginFragment : BaseFragment<FragmentLoginBinding>() {

    private val viewModel: LoginViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentLoginBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tietUsername.simpleInputWatcher {
            validate(
                it.toString(),
                binding.tietPass.text.toString(),
                binding.tietPassConfirm.text.toString()
            )
        }

        binding.tietPass.simpleInputWatcher {
            validate(
                binding.tietUsername.text.toString(),
                it.toString(),
                binding.tietPassConfirm.text.toString()
            )
        }

        binding.tietPassConfirm.simpleInputWatcher {
            validate(
                binding.tietUsername.text.toString(),
                binding.tietPass.text.toString(),
                it.toString()
            )
        }

        binding.btn.setOnClickListener {
            val result = viewModel.verifyInputs(
                binding.tietUsername.text.toString(),
                binding.tietPass.text.toString(),
                binding.tietPassConfirm.text.toString()
            )
            Toast.makeText(
                requireContext(),
                result.toString(),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun checkInputs(
        username: String,
        password: String,
        passwordConfirmation: String
    ): Boolean {
        if (username.isEmpty() || password.isEmpty() || passwordConfirmation.isEmpty() || !passwordConfirmation.equals(password, false)) {
            return false
        }
        return true
    }

    private fun validate(
        username: String,
        password: String,
        passwordConfirmation: String
    ) {
        binding.btn.isEnabled = checkInputs(username, password, passwordConfirmation)
    }
}