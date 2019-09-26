package com.hqapps.dazntestapp.ui.main.curriculumvitaedetails

import androidx.lifecycle.ViewModel
import com.hqapps.dazntestapp.app.ViewModelKey
import com.hqapps.domain.interactor.LoadCurriculumVitaeUseCase
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module(
    includes = [
        CurriculumVitaeDetailsModule.ProvideViewModel::class
    ]
)
abstract class CurriculumVitaeDetailsModule {

    @ContributesAndroidInjector
    abstract fun bind(): CurriculumVitaeDetailsFragment

    @Module
    class ProvideViewModel {

        @Provides
        @IntoMap
        @ViewModelKey(CurriculumVitaeViewModel::class)
        fun provideListNotesViewModel(loadCurriculumVitaeUseCase: LoadCurriculumVitaeUseCase): ViewModel =
            CurriculumVitaeViewModel(loadCurriculumVitaeUseCase)
    }

}