//package com.hqapps.dazntestapp.ui.main.events
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
//import com.hqapps.dazntestapp.ui.videoplayer.VideoPlayerActivity
//import com.hqapps.domain.model.EventEntity
//import kotlinx.android.synthetic.main.fragment_events.*
//import javax.inject.Inject
//
//class EventsFragment : BaseFragment() {
//
//    @Inject
//    lateinit var eventsViewModel: EventsViewModel
//
//    @Inject
//    lateinit var eventsAdapter: DomainBaseEntityAdapter<EventEntity>
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        eventsViewModel.getEvents().observe(this, Observer(eventsAdapter::updateList))
//        eventsViewModel.errorLiveData.observe(this, Observer(::processError))
//        eventsViewModel.showHideProgression.observe(this, Observer(::processShowHideProgression))
//    }
//
//    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
//        inflater.inflate(R.layout.fragment_events, container, false)
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//        recycler_view.addItemDecoration(CustomDividerItemDecoration(context))
//        recycler_view.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
//        recycler_view.adapter = eventsAdapter
//        eventsAdapter.setOnItemClickedListener(onItemClickedListener)
//        if (savedInstanceState == null)
//            eventsViewModel.loadEvents()
//    }
//
//    private val onItemClickedListener = object : DomainBaseEntityAdapter.OnRecyclerViewItemClickedListener {
//        override fun onItemClicked(atPosition: Int) {
//            var item = eventsAdapter.getItem(atPosition) as? EventEntity
//            item?.let { eventEntity ->
//                context?.let { context ->
//                    startActivity(
//                        VideoPlayerActivity.getLaunchIntent(context, eventEntity.videoUrl)
//                    )
//                }
//            }
//        }
//    }
//}