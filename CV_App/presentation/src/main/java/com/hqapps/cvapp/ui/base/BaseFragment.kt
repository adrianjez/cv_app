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

/*
abstract class BaseFragment: DaggerFragment(){

    protected fun processError(message: String) =
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()

    protected fun processShowHideProgression(showOrHide: Boolean){
        progress.visibility = if (showOrHide) View.VISIBLE else View.GONE
    }
}*/
abstract class BaseFragment<VIEW : BaseView, VM : BaseViewModel<VIEW>, BINDING : ViewDataBinding>(
    @LayoutRes private val layout: Int
) : DaggerFragment(),
    BaseView {

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
        afterCreateView(binding.root)
        return binding.root
    }

    open fun afterCreateView(view: View) {}


    override fun onStart() {
        Timber.w("onStart ${hashCode()}")
        super.onStart()
        @Suppress("UNCHECKED_CAST")
        viewModel.onAttach(this as VIEW)
    }

    override fun onStop() {
        Timber.w("onStop ${hashCode()}")
        @Suppress("UNCHECKED_CAST")
        viewModel.onDetach(this as VIEW)
        super.onStop()
    }

    protected fun requireMainActivity() = requireActivity() as MainActivity
    private fun requireBaseActivity() = requireActivity() as AppCompatActivity
}