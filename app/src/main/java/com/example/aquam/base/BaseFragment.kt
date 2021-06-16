package com.example.aquam.base

import androidx.fragment.app.Fragment
import com.example.aquam.ui.MainActivity

abstract class BaseFragment : Fragment(), BaseView {

    override fun showProgressDialog() {
        (activity as MainActivity).showProgressDialog()
    }

    override fun hideProgressDialog() {
        (activity as MainActivity).hideProgressDialog()
    }

}