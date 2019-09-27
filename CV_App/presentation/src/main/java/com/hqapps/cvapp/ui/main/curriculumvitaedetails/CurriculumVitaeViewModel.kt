package com.hqapps.cvapp.ui.main.curriculumvitaedetails

import android.util.Log
import androidx.databinding.ObservableField
import com.hqapps.cvapp.ui.base.BaseView
import com.hqapps.cvapp.ui.base.BaseViewModel
import com.hqapps.domain.interactor.LoadCurriculumVitaeUseCase
import com.hqapps.domain.model.CurriculumVitaeEntity
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.functions.Consumer
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

interface CurriculumVitaeView : BaseView
class CurriculumVitaeViewModel @Inject constructor(
    private val loadCurriculumVitaeDetailsUseCase: LoadCurriculumVitaeUseCase
): BaseViewModel<CurriculumVitaeView>() {

    val adapter = ObservableField<CurriculumVitaeDetailsAdapter>()

    override fun onAttach(view: CurriculumVitaeView) {
        super.onAttach(view)
        loadCurriculumVitaeDetailsUseCase.buildUseCaseObservable("cv_details.json")
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe (
                onCurriculumDetailsClaimed, Consumer {
                    Log.e("","")
                }
            ).disposeOnDetach()
    }

    val onCurriculumDetailsClaimed = Consumer<CurriculumVitaeEntity> {
        adapter.set(CurriculumVitaeDetailsAdapter(it))
    }
}