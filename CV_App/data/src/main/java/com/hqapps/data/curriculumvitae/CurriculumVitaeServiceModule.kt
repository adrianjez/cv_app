package com.hqapps.data.curriculumvitae

import com.hqapps.domain.repository.CurriculumVitaeRepository
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
class CurriculumVitaeServiceModule {

    @Provides
    @Singleton
    internal fun provideCurriculmVitaeAPI(retrofit: Retrofit): CurriculumVitaeAPI {
        return retrofit.create(CurriculumVitaeAPI::class.java)
    }

    @Provides
    @Singleton
    fun provideCurriculumVitaeRepository(curriculumVitaeRepository: CurriculumVitaeRepositoryImplementation): CurriculumVitaeRepository {
        return curriculumVitaeRepository
    }
}