//package com.hqapps.dazntestapp.ui.main.schedule
//
//import android.content.Context
//import android.view.LayoutInflater
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.ViewModelProvider
//import androidx.lifecycle.ViewModelProviders
//import com.hqapps.dazntestapp.app.ViewModelKey
//import com.hqapps.dazntestapp.ui.main.adapter.DomainBaseEntityAdapter
//import com.hqapps.domain.interactor.LoadScheduleUseCase
//import com.hqapps.domain.model.ScheduleEntity
//import dagger.Module
//import dagger.Provides
//import dagger.android.ContributesAndroidInjector
//import dagger.multibindings.IntoMap
//
//@Module(includes = [
//    ScheduleModule.ProvideViewModel::class
//])
//abstract class ScheduleModule {
//
//    @ContributesAndroidInjector(modules = [
//        InjectViewModel::class, InjectAdapter::class
//    ])
//    abstract fun bind(): ScheduleFragment
//
//    @Module
//    class ProvideViewModel {
//
//        @Provides
//        @IntoMap
//        @ViewModelKey(ScheduleViewModel::class)
//        fun provideScheduleViewModel(notesRepository: LoadScheduleUseCase): ViewModel = ScheduleViewModel(notesRepository)
//    }
//
//    @Module
//    class InjectAdapter {
//        @Provides
//        internal fun provideAdapter(inflater: LayoutInflater) : DomainBaseEntityAdapter<ScheduleEntity>
//                = DomainBaseEntityAdapter(inflater)
//
//        @Provides
//        internal fun providesLayoutInflater(target: ScheduleFragment) :
//                LayoutInflater = target.context?.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//    }
//
//    @Module
//    class InjectViewModel {
//
//        @Provides
//        fun provideListNotesViewModel(
//            factory: ViewModelProvider.Factory,
//            target: ScheduleFragment
//        ): ScheduleViewModel =
//            ViewModelProviders.of(target, factory).get(ScheduleViewModel::class.java)
//    }
//}