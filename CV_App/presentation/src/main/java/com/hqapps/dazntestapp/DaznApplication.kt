package com.hqapps.dazntestapp

import com.hqapps.dazntestapp.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class DaznApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}