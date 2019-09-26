package com.hqapps.dazntestapp.ui.main.curriculumvitaedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hqapps.dazntestapp.R
import com.hqapps.domain.model.CurriculumVitaeEntity

class CurriculumVitaeDetailsAdapter(private val curriculumDetails: CurriculumVitaeEntity)
    : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    enum class VIEW_TYPE(val id: Int) {
        ABOUT_VIEW_TYPE(0)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType){
            VIEW_TYPE.ABOUT_VIEW_TYPE.id -> AboutRecyclerViewHolder(
                LayoutInflater.from(parent.context).inflate(R.layout.curruculum_vitae_details_about_view_holder, parent, false)
            )
            else -> throw RuntimeException("Unsupported view type found")
        }

    override fun getItemCount(): Int = 1

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
    }

    override fun getItemViewType(position: Int): Int {
        return when (position){
            0 -> VIEW_TYPE.ABOUT_VIEW_TYPE.id
            else -> throw RuntimeException("Unsupported view type found")
        }
    }

    inner class AboutRecyclerViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }

}