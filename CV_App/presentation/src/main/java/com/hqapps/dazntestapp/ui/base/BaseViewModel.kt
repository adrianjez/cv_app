package com.hqapps.dazntestapp.ui.base

import android.text.SpannableString
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentStatePagerAdapter
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.squareup.picasso.Picasso
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import timber.log.Timber
import java.text.SimpleDateFormat
import java.util.*

abstract class BaseViewModel<T : BaseView> : ViewModel() {

    var view: T? = null

    private val compositeDisposable = CompositeDisposable()

    @Synchronized
    open fun onAttach(view: T) {
        Timber.w("onAttach ${view.hashCode()} -  ${hashCode()}")
        this.view = view
    }

    fun Disposable.disposeOnDetach() {
        compositeDisposable.add(this)
    }

    @Synchronized
    open fun onDetach(view: T) {
        Timber.w("onDetach ${view.hashCode()} -  ${hashCode()}")
        compositeDisposable.clear()
        if (this.view == view)
            this.view = null
    }

    object DataBindingAdapter {
        @BindingAdapter("bind:imageUrl")
        @JvmStatic
        fun loadImage(view: ImageView, imageUrl: String?) =
            Picasso.get().load(imageUrl).into(view)

        @BindingAdapter("bind:date")
        @JvmStatic
        fun loadDate(view: TextView, milliseconds: Long?) {
            var date = ""
            if(milliseconds != null) date = SimpleDateFormat("MMM dd HH:mm", Locale.getDefault())
                .format(milliseconds).capitalize()
            view.text = date
        }

        @BindingAdapter("setAdapter")
        @JvmStatic
        fun bindViewPagerAdapter(viewPager: ViewPager, adapter: FragmentStatePagerAdapter) {
            viewPager.adapter = adapter
        }

        @BindingAdapter("bind:setSpannableString")
        @JvmStatic
        fun bindTextViewSpannableString(textView: TextView, spannableString: SpannableString) {
            textView.setText(spannableString, TextView.BufferType.SPANNABLE)
        }

        @BindingAdapter("bind:imageVector")
        @JvmStatic
        fun bindTextViewSpannableString(imageView: ImageView, @DrawableRes imageResource: Int) {
            imageView.setImageResource(imageResource)
        }

        @BindingAdapter("bind:recyclerViewAdapter")
        @JvmStatic
        fun bindRecyclerViewAdapter(view: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?) =
            adapter?.let {
                view.layoutManager = LinearLayoutManager(view.context, RecyclerView.VERTICAL, false)
                view.adapter = adapter
            }
    }
}