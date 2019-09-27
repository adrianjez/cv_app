package com.hqapps.cvapp.app

import com.hqapps.data.curriculumvitae.CurriculumVitaeServiceModule
import com.hqapps.cvapp.CVApplication
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        NetworkModule::class,
        CurriculumVitaeServiceModule::class
    ]
)
interface AppComponent : AndroidInjector<CVApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<CVApplication>()
}
