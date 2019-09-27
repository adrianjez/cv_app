//package com.hqapps.dazntestapp.ui.main.schedule
//
//import android.os.Bundle
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.lifecycle.Observer
//import androidx.recyclerview.widget.LinearLayoutManager
//import androidx.recyclerview.widget.RecyclerView
//import com.hqapps.dazntestapp.R
//import com.hqapps.dazntestapp.ui.base.BaseFragment
//import com.hqapps.dazntestapp.ui.decorators.CustomDividerItemDecoration
//import com.hqapps.dazntestapp.ui.main.adapter.DomainBaseEntityAdapter
//import com.hqapps.domain.model.ScheduleEntity
//import kotlinx.android.synthetic.main.fragment_events.*
//import javax.inject.Inject
//
//class ScheduleFragment: BaseFragment() {
//
//    @Inject
//    lateinit var scheduleViewModel: ScheduleViewModel
//
//    @Inject
//    lateinit var scheduleAdapter: DomainBaseEntityAdapter<ScheduleEntity>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        scheduleViewModel.getSchedule().observe(this, Observer(scheduleAdapter::updateList))
//        scheduleViewModel.errorLiveData.observe(this, Observer(::processError))
//        scheduleViewModel.showHideProgression.observe(this, Observer(::processShowHideProgression))
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
//        inflater.inflate(R.layout.fragment_schedule, container, false)
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        recycler_view.addItemDecoration(CustomDividerItemDecoration(context))
//        recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL ,false)
//        recycler_view.adapter = scheduleAdapter
//        if(savedInstanceState == null)
//            scheduleViewModel.loadSchedule()
//    }
//}