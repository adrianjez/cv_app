package com.hqapps.cvapp

import com.hqapps.cvapp.app.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class CVApplication : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAppComponent.builder().create(this)
    }
}