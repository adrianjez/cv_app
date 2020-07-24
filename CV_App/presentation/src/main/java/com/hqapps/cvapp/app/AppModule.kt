package com.hqapps.cvapp.app

import android.app.Application
import android.content.Context
import com.hqapps.cvapp.CVApplication
import com.hqapps.cvapp.ui.UiModule
import dagger.Binds
import dagger.Module
import dagger.android.support.AndroidSupportInjectionModule

@Module(
    includes = [
        AndroidSupportInjectionModule::class,
        UiModule::class
    ]
)
abstract class AppModule {

    @Binds
    internal abstract fun application(app: CVApplication): Application

    @Binds
    internal abstract fun applicationContext(app: CVApplication): Context

}
