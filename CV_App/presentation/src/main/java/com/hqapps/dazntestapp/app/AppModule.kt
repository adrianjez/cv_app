package com.hqapps.dazntestapp.app

import android.app.Application
import android.content.Context
import com.hqapps.dazntestapp.DaznApplication
import com.hqapps.dazntestapp.ui.UiModule
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

@Module(includes = [
    AndroidSupportInjectionModule::class,
    UiModule::class
])
abstract class AppModule {

    @Binds
    internal abstract fun application(app: DaznApplication): Application

    @Binds
    internal abstract fun applicationContext(app: DaznApplication): Context


}
