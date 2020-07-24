package com.hqapps.cvapp.ui.main.curriculumvitaedetails

import android.content.res.Resources
import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.hqapps.cvapp.R
import com.hqapps.cvapp.ui.base.BaseViewModel
import com.hqapps.domain.interactor.LoadCurriculumVitaeUseCase
import com.hqapps.domain.model.CurriculumVitaeEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CurriculumVitaeViewModel @Inject constructor(
    private val loadCurriculumVitaeDetailsUseCase: LoadCurriculumVitaeUseCase,
    private val resources: Resources
): BaseViewModel() {

    val adapter = ObservableField<CurriculumVitaeDetailsAdapter>()
    val errorMessageId = MutableLiveData<Int>()

    private val onCurriculumDetailsClaimed = Consumer<CurriculumVitaeEntity> {
        adapter.set(CurriculumVitaeDetailsAdapter(it, resources))
    }

    private val errorConsumer = Consumer<Throwable> {
        it.printStackTrace()
        errorMessageId.postValue(R.string.network_error_message)
    }

    init {
        loadCurriculumVitaeDetailsUseCase.buildUseCaseObservable("cv_details.json")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                onCurriculumDetailsClaimed, errorConsumer
            )
            .disposeOnDetach()
    }


}