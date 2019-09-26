package com.hqapps.dazntestapp.app

import com.hqapps.data.curriculumvitae.CurriculumVitaeServiceModule
import com.hqapps.data.events.EventsServiceModule
import com.hqapps.data.schedule.ScheduleServiceModule
import com.hqapps.dazntestapp.DaznApplication
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
        EventsServiceModule::class,
        ScheduleServiceModule::class,
    CurriculumVitaeServiceModule::class
    ]
)
interface AppComponent : AndroidInjector<DaznApplication> {

    @Component.Builder
    abstract class Builder : AndroidInjector.Builder<DaznApplication>()
}
