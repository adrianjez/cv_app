package com.hqapps.cvapp.ui.base

import androidx.databinding.BindingAdapter
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

abstract class BaseViewModel : ViewModel() {


    private val compositeDisposable = CompositeDisposable()

    fun Disposable.disposeOnDetach() {
        compositeDisposable.add(this)
    }

    object DataBindingAdapter {


        @BindingAdapter("recyclerViewAdapter")
        @JvmStatic
        fun bindRecyclerViewAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?) =
            adapter?.let {
                view.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
                view.adapter = adapter
            }
    }
}