package com.hqapps.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hqapps.data.curriculumvitae.CurriculumVitaeAPI
import com.hqapps.data.curriculumvitae.CurriculumVitaeRepositoryImplementation
import com.hqapps.domain.model.CurriculumVitaeEntity
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class EventsRepositoryImplementationTest : BaseDataTest() {

    private lateinit var eventsRepositoryImplementation: CurriculumVitaeRepositoryImplementation

    private lateinit var testData : CurriculumVitaeEntity

    @Mock
    private lateinit var cvApi: CurriculumVitaeAPI

    @Before
    fun setUp(){
        eventsRepositoryImplementation = CurriculumVitaeRepositoryImplementation(cvApi)
        val listType = object : TypeToken<CurriculumVitaeEntity>() {}.type
        testData = Gson().fromJson(loadJsonFileFromResources("test_cv.json"), listType)
    }

    @Test
    fun testLocalSearch() {
        BDDMockito.given(cvApi.getCurriculumVitaeDetails(""))
            .willReturn(Observable.just(testData))

        val observer = eventsRepositoryImplementation.loadCurriculumDetails("").test()

        Mockito.verify(cvApi).getCurriculumVitaeDetails("")

        observer.awaitTerminalEvent()
        observer.assertComplete()
            .assertNoErrors()
    }
}