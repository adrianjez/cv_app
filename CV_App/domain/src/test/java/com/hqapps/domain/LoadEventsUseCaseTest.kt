package com.hqapps.domain

import com.hqapps.domain.interactor.LoadCurriculumVitaeUseCase
import com.hqapps.domain.repository.CurriculumVitaeRepository
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.runners.MockitoJUnitRunner


@RunWith(MockitoJUnitRunner::class)
class LoadEventsUseCaseTest {

    private lateinit var loadCurriculumVitaeUseCase: LoadCurriculumVitaeUseCase

    @Mock
    private lateinit var mockCVRepository: CurriculumVitaeRepository

    @Before
    fun setUp(){
        loadCurriculumVitaeUseCase = LoadCurriculumVitaeUseCase(mockCVRepository)
    }

    @Test
    fun testLocalSearchUseCaseInteraction(){
        loadCurriculumVitaeUseCase.buildUseCaseObservable(null)
        Mockito.verify(mockCVRepository).loadCurriculumDetails("")
        Mockito.verifyNoMoreInteractions(mockCVRepository)
    }
}