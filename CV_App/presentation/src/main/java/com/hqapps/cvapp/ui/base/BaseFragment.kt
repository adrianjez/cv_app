package com.hqapps.cvapp.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.hqapps.cvapp.BR
import com.hqapps.cvapp.ui.main.MainActivity
import dagger.android.support.DaggerFragment
import timber.log.Timber
import javax.inject.Inject

abstract class BaseFragment<VM : BaseViewModel, BINDING : ViewDataBinding>(
    @LayoutRes private val layout: Int
) : DaggerFragment(){

    @Inject
    protected lateinit var viewModel: VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Timber.w("onCreateView ${hashCode()}")
        val binding: BINDING = DataBindingUtil.inflate(inflater, layout, container, false)
        Timber.w("onCreateView viewModel = ${viewModel.hashCode()}")
        binding.setVariable(BR.viewModel, viewModel)
        return binding.root
    }

    protected fun requireMainActivity() = requireActivity() as MainActivity
    private fun requireBaseActivity() = requireActivity() as AppCompatActivity
}