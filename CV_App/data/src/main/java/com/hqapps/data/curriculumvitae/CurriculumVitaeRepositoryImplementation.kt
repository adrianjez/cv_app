package com.hqapps.data.curriculumvitae

import com.hqapps.domain.model.CurriculumVitaeEntity
import com.hqapps.domain.repository.CurriculumVitaeRepository
import io.reactivex.Observable
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CurriculumVitaeRepositoryImplementation : CurriculumVitaeRepository {

    private val curriculumVitaeAPI: CurriculumVitaeAPI

    @Inject
    constructor(curriculumVitaeAPI: CurriculumVitaeAPI) {
        this.curriculumVitaeAPI = curriculumVitaeAPI
    }

    override fun loadCurriculumDetails(name: String): Observable<CurriculumVitaeEntity> =
        curriculumVitaeAPI.getCurriculumVitaeDetails(name)

}