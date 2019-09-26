package com.hqapps.dazntestapp.ui.main

import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module

@Module
abstract class MainActivityModule {

    @Binds
    abstract fun bindMainActivity(mainActivity: MainActivity): AppCompatActivity


}