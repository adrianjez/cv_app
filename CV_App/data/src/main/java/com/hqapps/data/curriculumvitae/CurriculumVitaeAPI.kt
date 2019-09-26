package com.hqapps.data.curriculumvitae

import com.hqapps.domain.model.CurriculumVitaeEntity
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface CurriculumVitaeAPI {

    @GET("adrianjez/cv_app/master/{cv_name}")
    fun getCurriculumVitaeDetails(@Path(value = "cv_name") cv_name: String) : Observable<CurriculumVitaeEntity>
}