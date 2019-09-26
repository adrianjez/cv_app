package com.hqapps.domain.interactor

import com.hqapps.domain.model.CurriculumVitaeEntity
import com.hqapps.domain.repository.CurriculumVitaeRepository
import io.reactivex.Observable
import javax.inject.Inject

class LoadCurriculumVitaeUseCase : BaseUseCase<CurriculumVitaeEntity, String> {

    private val repo: CurriculumVitaeRepository

    @Inject
    constructor(repository: CurriculumVitaeRepository) {
        this.repo = repository
    }

    override fun buildUseCaseObservable(params: String?): Observable<CurriculumVitaeEntity> =
        repo.loadCurriculumDetails(params ?: "")


}