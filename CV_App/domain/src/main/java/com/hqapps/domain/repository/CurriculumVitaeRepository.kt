package com.hqapps.domain.repository

import com.hqapps.domain.model.CurriculumVitaeEntity
import io.reactivex.Observable

interface CurriculumVitaeRepository{
    fun loadCurriculumDetails(name: String) : Observable<CurriculumVitaeEntity>
}