package com.hqapps.cvapp.ui.main.curriculumvitaedetails

import android.content.res.Resources
import androidx.lifecycle.ViewModel
import com.hqapps.cvapp.app.ViewModelKey
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
        fun provideCurriculumVitaeViewModel(loadCurriculumVitaeUseCase: LoadCurriculumVitaeUseCase,
                                      resources: Resources): ViewModel =
            CurriculumVitaeViewModel(loadCurriculumVitaeUseCase, resources)
    }

}