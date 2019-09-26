//package com.hqapps.dazntestapp.ui.main.events
//
//import android.content.Context
//import android.view.LayoutInflater
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.ViewModelProviders
//import com.hqapps.dazntestapp.app.ViewModelKey
//import com.hqapps.dazntestapp.ui.main.adapter.DomainBaseEntityAdapter
//import com.hqapps.domain.interactor.LoadEventsUseCase
//import com.hqapps.domain.model.EventEntity
//import dagger.Module
//import dagger.Provides
//import dagger.android.ContributesAndroidInjector
//import dagger.multibindings.IntoMap
//
//@Module(includes = [
//    EventsModule.ProvideViewModel::class
//])
//abstract class EventsModule {
//
//    @ContributesAndroidInjector(modules = [
//        InjectViewModel::class, InjectAdapter::class
//    ])
//    abstract fun bind(): EventsFragment
//
//    @Module
//    class ProvideViewModel {
//
//        @Provides
//        @IntoMap
//        @ViewModelKey(EventsViewModel::class)
//        fun provideListNotesViewModel(notesRepository: LoadEventsUseCase): ViewModel = EventsViewModel(notesRepository)
//    }
//
//    @Module
//    class InjectAdapter {
//        @Provides
//        internal fun provideAdapter(inflater: LayoutInflater) : DomainBaseEntityAdapter<EventEntity>
//                = DomainBaseEntityAdapter(inflater)
//
//        @Provides
//        internal fun providesLayoutInflater(target: EventsFragment) :
//                LayoutInflater = target.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//    }
//
//    @Module
//    class InjectViewModel {
//
//        @Provides
//        fun provideListNotesViewModel(
//            factory: ViewModelProvider.Factory,
//            target: EventsFragment
//        ): EventsViewModel =
//            ViewModelProviders.of(target, factory).get(EventsViewModel::class.java)
//    }
//}