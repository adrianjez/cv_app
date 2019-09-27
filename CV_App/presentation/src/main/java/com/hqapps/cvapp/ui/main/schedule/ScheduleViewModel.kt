//package com.hqapps.dazntestapp.ui.main.schedule
//
//import android.os.Handler
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import com.hqapps.dazntestapp.ui.base.BaseViewModel
//import com.hqapps.domain.interactor.LoadScheduleUseCase
//import com.hqapps.domain.model.ScheduleEntity
//import io.reactivex.android.schedulers.AndroidSchedulers
//import io.reactivex.schedulers.Schedulers
//import javax.inject.Inject
//
//class ScheduleViewModel : BaseViewModel {
//
//    private val loadScheduleUseCase: LoadScheduleUseCase
//
//    var responseLiveData: MutableLiveData<List<ScheduleEntity>> = MutableLiveData()
//        private set
//
//    var handler = Handler()
//
//    @Inject
//    constructor(loadScheduleUseCase: LoadScheduleUseCase) {
//        this.loadScheduleUseCase = loadScheduleUseCase
//    }
//
//    fun getSchedule() : LiveData<List<ScheduleEntity>> = responseLiveData
//
//    fun loadSchedule() {
//        val runnableTask = object : Runnable {
//            override fun run() {
//                showHideProgression.postValue(true)
//                disposables.add(
//                    loadScheduleUseCase.buildUseCaseObservable(null)
//                        .subscribeOn(Schedulers.io())
//                        .observeOn(AndroidSchedulers.mainThread())
//                        .subscribe({ resp ->
//                            responseLiveData.postValue(resp)
//                            showHideProgression.postValue(false)
//                        }, { error ->
//                            errorLiveData.postValue(error.message)
//                            showHideProgression.postValue(false)
//                        })
//                )
//                handler.postDelayed(this, 30*1000)
//            }
//        }
//        handler.post(runnableTask)
//    }
//
//    override fun onCleared() {
//        super.onCleared()
//        handler.removeCallbacksAndMessages(null)
//    }
//}