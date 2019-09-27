package com.hqapps.cvapp.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hqapps.cvapp.app.AppViewModelFactory
import com.hqapps.cvapp.ui.main.MainActivity
import com.hqapps.cvapp.ui.main.MainActivityModule
import com.hqapps.cvapp.ui.main.curriculumvitaedetails.CurriculumVitaeDetailsModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import javax.inject.Provider

@Module(includes = [
    UiModule.UIModuleProvider::class,
    CurriculumVitaeDetailsModule::class,
    MainActivityModule::class
])
class UiModule {

    @Provides
    fun provideViewModelFactory(
        providers: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
    ): ViewModelProvider.Factory =
        AppViewModelFactory(providers)

    @Module
    abstract class UIModuleProvider {
        @ContributesAndroidInjector(modules = [MainActivityModule::class])
        internal abstract fun mainActivityInjector(): MainActivity
    }
}