package com.hqapps.cvapp.ui.main.curriculumvitaedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.hqapps.cvapp.R
import com.hqapps.domain.model.CurriculumVitaeEntity
import com.hqapps.domain.model.WorkHistoryDetails
import kotlinx.android.synthetic.main.curriculum_vitae_details_details_view_holder.view.*
import kotlinx.android.synthetic.main.curriculum_vitae_details_subtitle_view_holder.view.*
import kotlinx.android.synthetic.main.curriculum_vitae_details_title_view_holder.view.*

class CurriculumVitaeDetailsAdapter(
    private val curriculumDetails: CurriculumVitaeEntity,
    private var mainData: ArrayList<ViewType> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        rebuildList()
    }

    enum class VIEW_TYPE(val id: Int) {
        ABOUT_VIEW_TYPE(0),
        DETAILS_TITLE(1),
        DETAILS_SUBTITLE(2),
        DETAILS_DETAILS(3)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            VIEW_TYPE.ABOUT_VIEW_TYPE.id -> AboutRecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curruculum_vitae_details_about_view_holder, parent, false
                )
            )
            VIEW_TYPE.DETAILS_TITLE.id -> TitleViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curriculum_vitae_details_title_view_holder, parent, false
                )
            )
            VIEW_TYPE.DETAILS_SUBTITLE.id -> SubtitleViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curriculum_vitae_details_subtitle_view_holder, parent, false
                )
            )
            VIEW_TYPE.DETAILS_DETAILS.id -> DetailsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curriculum_vitae_details_details_view_holder, parent, false
                )
            )
            else -> throw RuntimeException("Unsupported view type found")
        }

    override fun getItemCount(): Int = mainData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)){
            VIEW_TYPE.ABOUT_VIEW_TYPE.id -> {}
            VIEW_TYPE.DETAILS_TITLE.id -> (holder as TitleViewHolder).bind(
                (mainData[position] as DetailsViewTypeTitle).title
            )
            VIEW_TYPE.DETAILS_SUBTITLE.id -> (holder as SubtitleViewHolder).bind(
                (mainData[position] as DetailsViewTypeSubtitle).subtitle
            )
            VIEW_TYPE.DETAILS_DETAILS.id -> (holder as DetailsViewHolder).bind(
                (mainData[position] as DetailsViewTypeDescription).workHistoryDetails
            )
        }
    }

    override fun getItemViewType(position: Int): Int = mainData[position].viewTypeID

    private fun rebuildList() {
        mainData.clear()
        mainData.add(AboutViewType(VIEW_TYPE.ABOUT_VIEW_TYPE.id))
        if (curriculumDetails.work_history.size > 0) {
            mainData.add(DetailsViewTypeTitle(VIEW_TYPE.DETAILS_TITLE.id, "Work history"))
            curriculumDetails.work_history.forEach { workHistory ->
                mainData.add(
                    DetailsViewTypeSubtitle(VIEW_TYPE.DETAILS_SUBTITLE.id, workHistory.title)
                )
                workHistory.details.forEach { workHistoryDetails ->
                    mainData.add(
                        DetailsViewTypeDescription(VIEW_TYPE.DETAILS_DETAILS.id, workHistoryDetails)
                    )
                }
            }
        }
    }

    inner class AboutRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    inner class TitleViewHolder(itemView: View,
                                private val title : TextView = itemView.titleContainer)
        : RecyclerView.ViewHolder(itemView) {

        fun bind(title: String){
            this.title.text = title
        }
    }

    inner class SubtitleViewHolder(itemView: View,
                                private val subtitle : TextView = itemView.subtitleContainer)
        : RecyclerView.ViewHolder(itemView) {

        fun bind(subtitle: String){
            this.subtitle.text = subtitle
        }
    }

    inner class DetailsViewHolder(itemView: View,
                                  private val detailsH1 : TextView = itemView.details_h1,
                                  private val detailsH2 : TextView = itemView.details_h2,
                                  private val detailsH3 : TextView = itemView.details_h3)
        : RecyclerView.ViewHolder(itemView) {

        fun bind(workHistoryDetails: WorkHistoryDetails){
            detailsH1.text = workHistoryDetails.title
            detailsH2.text = workHistoryDetails.subtitle
            detailsH3.text = workHistoryDetails.details
        }
    }
}