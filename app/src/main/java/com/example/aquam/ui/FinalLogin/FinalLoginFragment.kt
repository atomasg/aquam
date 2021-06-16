package com.example.aquam.ui.FinalLogin

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.aquam.base.BaseFragment
import com.example.aquam.databinding.FragmentLoginBinding

class FinalLoginFragment : BaseFragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var presenter: LoginPresenter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        presenter.attachView(this, lifecycle)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val username = binding.tvEmail
        val password = binding.tvPassword
        val login = binding.emailSignInButton
        val loading = binding.loginProgress

    }

}