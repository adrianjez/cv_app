//package com.hqapps.dazntestapp.ui.main.events
//
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.hqapps.dazntestapp.ui.base.BaseViewModel
//import com.hqapps.domain.interactor.LoadEventsUseCase
//import com.hqapps.domain.model.EventEntity
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
//import javax.inject.Inject
//
//class EventsViewModel : BaseViewModel {
//
//    private val loadEventsUseCase: LoadEventsUseCase
//
//    var responseLiveData: MutableLiveData<List<EventEntity>> = MutableLiveData()
//        private set
//
//    @Inject
//    constructor(loadEventsUseCase: LoadEventsUseCase) {
//        this.loadEventsUseCase = loadEventsUseCase
//    }
//
//    fun getEvents() : LiveData<List<EventEntity>> = responseLiveData
//
//    fun loadEvents() {
//        showHideProgression.postValue(true)
//        disposables.add(
//            loadEventsUseCase.buildUseCaseObservable(null)
//                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({ resp ->
//                    responseLiveData.postValue(resp)
//                    showHideProgression.postValue(false)
//                }, { error ->
//                    errorLiveData.postValue(error.message)
//                    showHideProgression.postValue(false)
//                })
//        )
//    }
//}