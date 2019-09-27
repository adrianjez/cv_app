//package com.hqapps.domain
//
//import com.hqapps.domain.interactor.LoadScheduleUseCase
//import com.hqapps.domain.repository.ScheduleRepository
//import org.junit.Before
//import org.junit.Test
//import org.junit.runner.RunWith
//import org.mockito.Mock
//import org.mockito.Mockito
//import org.mockito.runners.MockitoJUnitRunner
//
//@RunWith(MockitoJUnitRunner::class)
//class LoadScheduleUseCaseTest {
//
//    private lateinit var loadScheduleUseCase: LoadScheduleUseCase
//
//    @Mock
//    private lateinit var mockScheduleRepository: ScheduleRepository
//
//    @Before
//    fun setUp(){
//        loadScheduleUseCase = LoadScheduleUseCase(mockScheduleRepository)
//    }
//
//    @Test
//    fun testLocalSearchUseCaseInteraction(){
//        loadScheduleUseCase.buildUseCaseObservable(null)
//        Mockito.verify(mockScheduleRepository).loadSchedule()
//        Mockito.verifyNoMoreInteractions(mockScheduleRepository)
//    }
//}