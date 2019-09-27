//package com.hqapps.domain
//
//import com.hqapps.domain.interactor.LoadEventsUseCase
//import com.hqapps.domain.repository.EventsRepository
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.runners.MockitoJUnitRunner
//
//
//@RunWith(MockitoJUnitRunner::class)
//class LoadEventsUseCaseTest {
//
//    private lateinit var loadEventsUseCase: LoadEventsUseCase
//
//    @Mock
//    private lateinit var mockEventsRepository: EventsRepository
//
//    @Before
//    fun setUp(){
//        loadEventsUseCase = LoadEventsUseCase(mockEventsRepository)
//    }
//
//    @Test
//    fun testLocalSearchUseCaseInteraction(){
//        loadEventsUseCase.buildUseCaseObservable(null)
//        Mockito.verify(mockEventsRepository).loadEvents()
//        Mockito.verifyNoMoreInteractions(mockEventsRepository)
//    }
//}