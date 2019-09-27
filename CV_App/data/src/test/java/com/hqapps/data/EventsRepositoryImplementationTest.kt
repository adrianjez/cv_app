//package com.hqapps.data
//
//import com.google.gson.Gson
//import com.google.gson.reflect.TypeToken
//import com.hqapps.data.events.EventsAPI
//import com.hqapps.data.events.EventsRepositoryImplementation
//import com.hqapps.domain.model.EventEntity
//import io.reactivex.Observable
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.BDDMockito
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.runners.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class EventsRepositoryImplementationTest : BaseDataTest() {
//
//    private lateinit var eventsRepositoryImplementation: EventsRepositoryImplementation
//
//    private lateinit var testData : List<EventEntity>
//
//    @Mock
//    private lateinit var eventsAPI: EventsAPI
//
//    @Before
//    fun setUp(){
//        eventsRepositoryImplementation = EventsRepositoryImplementation(eventsAPI)
//        val listType = object : TypeToken<List<EventEntity>>() {}.type
//        testData = Gson().fromJson(loadJsonFileFromResources("test_events.json"), listType)
//    }
//
//    @Test
//    fun testLocalSearch() {
//        BDDMockito.given(eventsAPI.getEvents())
//            .willReturn(Observable.just(testData))
//
//        val observer = eventsRepositoryImplementation.loadEvents().test()
//
//        Mockito.verify(eventsAPI).getEvents()
//
//        observer.awaitTerminalEvent()
//        observer.assertComplete()
//            .assertNoErrors()
//            .assertValue { l -> l.size == 3 } // comes from test_events.json*/
//    }
//}