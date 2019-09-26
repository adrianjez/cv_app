package com.hqapps.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.hqapps.data.schedule.ScheduleAPI
import com.hqapps.data.schedule.ScheduleRepositoryImplementation
import com.hqapps.domain.model.ScheduleEntity
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.BDDMockito
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class ScheduleRepositoryImplementationTest : BaseDataTest() {

    private lateinit var scheduleRepositoryImplementation: ScheduleRepositoryImplementation

    private lateinit var testData : List<ScheduleEntity>

    @Mock
    private lateinit var scheduleAPI: ScheduleAPI

    @Before
    fun setUp(){
        scheduleRepositoryImplementation = ScheduleRepositoryImplementation(scheduleAPI)
        val listType = object : TypeToken<List<ScheduleEntity>>() {}.type
        testData = Gson().fromJson(loadJsonFileFromResources("test_schedule.json"), listType)
    }

    @Test
    fun testLocalSearch() {
        BDDMockito.given(scheduleAPI.getSchedule())
            .willReturn(Observable.just(testData))

        val observer = scheduleRepositoryImplementation.loadSchedule().test()

        Mockito.verify(scheduleAPI).getSchedule()

        observer.awaitTerminalEvent()
        observer.assertComplete()
            .assertNoErrors()
            .assertValue { l -> l.size == 6 } // comes from test_schedule.json*/
    }
}