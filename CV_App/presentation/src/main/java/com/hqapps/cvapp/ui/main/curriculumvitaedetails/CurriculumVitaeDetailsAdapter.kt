package com.hqapps.cvapp.ui.main.curriculumvitaedetails

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.hqapps.cvapp.R
import com.hqapps.domain.model.CurriculumVitaeEntity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.curriculum_vitae_details_details_view_holder.view.*
import kotlinx.android.synthetic.main.curriculum_vitae_details_details_view_holder.view.details_card_view
import kotlinx.android.synthetic.main.curriculum_vitae_details_subtitle_view_holder.view.*
import kotlinx.android.synthetic.main.curriculum_vitae_details_title_view_holder.view.*
import kotlinx.android.synthetic.main.curriculum_vitae_profile_view_holder.view.*
import kotlinx.android.synthetic.main.curriculum_vitae_skill_view_holder.view.*
import kotlinx.android.synthetic.main.curruculum_vitae_details_about_view_holder.view.*

class CurriculumVitaeDetailsAdapter(
    private val curriculumDetails: CurriculumVitaeEntity,
    private var mainData: ArrayList<ViewType> = arrayListOf()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    init {
        rebuildList()
    }

    enum class VIEWTYPE(val id: Int) {
        PROFILE_VIEWTYPE(0),
        ABOUT_VIEWTYPE(1),
        DETAILS_TITLE(2),
        DETAILS_SUBTITLE(3),
        DETAILS_DETAILS(4),
        SKILLS_VIEW_TYPE(5)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder =
        when (viewType) {
            VIEWTYPE.SKILLS_VIEW_TYPE.id -> SkillViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curriculum_vitae_skill_view_holder, parent, false
                )
            )
            VIEWTYPE.PROFILE_VIEWTYPE.id -> ProfileViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curriculum_vitae_profile_view_holder, parent, false
                )
            )
            VIEWTYPE.ABOUT_VIEWTYPE.id -> AboutViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curruculum_vitae_details_about_view_holder, parent, false
                )
            )
            VIEWTYPE.DETAILS_TITLE.id -> TitleViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curriculum_vitae_details_title_view_holder, parent, false
                )
            )
            VIEWTYPE.DETAILS_SUBTITLE.id -> SubtitleViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curriculum_vitae_details_subtitle_view_holder, parent, false
                )
            )
            VIEWTYPE.DETAILS_DETAILS.id -> DetailsViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.curriculum_vitae_details_details_view_holder, parent, false
                )
            )
            else -> throw RuntimeException("Unsupported view type found")
        }

    override fun getItemCount(): Int = mainData.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            VIEWTYPE.PROFILE_VIEWTYPE.id -> (holder as ProfileViewHolder).bind(
                (mainData[position] as ProfileViewType)
            )
            VIEWTYPE.ABOUT_VIEWTYPE.id -> (holder as AboutViewHolder).bind(
                (mainData[position] as AboutViewType)
            )
            VIEWTYPE.DETAILS_TITLE.id -> (holder as TitleViewHolder).bind(
                (mainData[position] as DetailsViewTypeTitle).title
            )
            VIEWTYPE.DETAILS_SUBTITLE.id -> (holder as SubtitleViewHolder).bind(
                (mainData[position] as DetailsViewTypeSubtitle).subtitle
            )
            VIEWTYPE.DETAILS_DETAILS.id -> (holder as DetailsViewHolder).bind(
                (mainData[position] as DetailsViewTypeDescription)
            )
            VIEWTYPE.SKILLS_VIEW_TYPE.id -> (holder as SkillViewHolder).bind(
                (mainData[position] as SkillViewType)
            )
        }
    }

    override fun getItemViewType(position: Int): Int = mainData[position].viewTypeID

    private fun rebuildList() {
        mainData.clear()
        mainData.add(
            ProfileViewType(
                VIEWTYPE.PROFILE_VIEWTYPE.id,
                imageUrl = curriculumDetails.photo_url,
                displayName = curriculumDetails.title,
                displayTitle = curriculumDetails.subtitle
            )
        )
        mainData.add(
            AboutViewType(
                VIEWTYPE.ABOUT_VIEWTYPE.id,
                about = curriculumDetails.about,
                age = curriculumDetails.age.toString(),
                addressLine1 = curriculumDetails.address.line1,
                addressLine2 = curriculumDetails.address.line2,
                email = curriculumDetails.email,
                phone = curriculumDetails.phone,
                dateOfBirth = curriculumDetails.date_of_birth
            )
        )
        if (curriculumDetails.work_history.size > 0) {
            mainData.add(DetailsViewTypeTitle(VIEWTYPE.DETAILS_TITLE.id, "Work history"))
            curriculumDetails.work_history.forEachIndexed { i, workHistory ->
                mainData.add(
                    DetailsViewTypeSubtitle(VIEWTYPE.DETAILS_SUBTITLE.id, workHistory.title)
                )
                workHistory.details.forEachIndexed { index, workHistoryDetails ->
                    mainData.add(
                        DetailsViewTypeDescription(
                            VIEWTYPE.DETAILS_DETAILS.id,
                            workHistoryDetails = workHistoryDetails,
                            isLast = (index == workHistory.details.size.minus(1) &&
                                    i == curriculumDetails.work_history.size.minus(1))
                        )
                    )
                }
            }
        }

        if (curriculumDetails.skills.size > 0) {
            mainData.add(DetailsViewTypeTitle(VIEWTYPE.DETAILS_TITLE.id, "Professional skills"))
            curriculumDetails.skills.forEachIndexed {index, skill ->
                mainData.add(
                    SkillViewType(
                        VIEWTYPE.SKILLS_VIEW_TYPE.id,
                        skill = skill,
                        isLast = (index == curriculumDetails.skills.size.minus(1))
                    )
                )
            }
        }
    }

    inner class SkillViewHolder(
        itemView: View,
        private val skillNameContainer: TextView = itemView.skill_name_continer,
        private val skillProgress: ProgressBar = itemView.skill_progress,
        private val cardView: CardView = itemView.skill_card_view
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(listItemData: SkillViewType){
            skillNameContainer.text = listItemData.skill.name
            skillProgress.progress = listItemData.skill.percentage
            if (listItemData.isLast) {
                (cardView.layoutParams as FrameLayout.LayoutParams).bottomMargin = 0
            } else {
                (cardView.layoutParams as FrameLayout.LayoutParams).bottomMargin = -50
            }
        }
    }

    inner class ProfileViewHolder(
        itemView: View,
        private val profilePhotoContainer: ImageView = itemView.profile_photo_container,
        private val displayNameContainer: TextView = itemView.display_name_container,
        private val displayTitleContainer: TextView = itemView.display_title_container
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(listItemData: ProfileViewType) {
            displayNameContainer.text = listItemData.displayName
            displayTitleContainer.text = listItemData.displayTitle
            Picasso
                .get()
                .load(listItemData.imageUrl)
                .into(profilePhotoContainer)
        }
    }

    inner class AboutViewHolder(
        itemView: View,
        private val aboutContainer: TextView = itemView.about_container,
        private val ageContainer: TextView = itemView.age_container,
        private val addressLine1Container: TextView = itemView.address_line1_container,
        private val addressLine2Container: TextView = itemView.address_line2_container,
        private val emailContainer: TextView = itemView.email_container,
        private val phoneContainer: TextView = itemView.phone_container,
        private val dateOfBirthContainer: TextView = itemView.date_of_birth_container
    ) : RecyclerView.ViewHolder(itemView) {


        fun bind(listItemData: AboutViewType) {
            aboutContainer.text = listItemData.about
            ageContainer.text = listItemData.age
            addressLine1Container.text = listItemData.addressLine1
            addressLine2Container.text = listItemData.addressLine2
            emailContainer.text = listItemData.email
            phoneContainer.text = listItemData.phone
            dateOfBirthContainer.text = listItemData.dateOfBirth
        }
    }

    inner class TitleViewHolder(
        itemView: View,
        private val title: TextView = itemView.details_title_container
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(title: String) {
            this.title.text = title
        }
    }

    inner class SubtitleViewHolder(
        itemView: View,
        private val subtitle: TextView = itemView.subtitle_container
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(subtitle: String) {
            this.subtitle.text = subtitle
        }
    }

    inner class DetailsViewHolder(
        itemView: View,
        private val detailsH1: TextView = itemView.details_h1,
        private val detailsH2: TextView = itemView.details_h2,
        private val detailsH3: TextView = itemView.details_h3,
        private val cardView: CardView = itemView.details_card_view,
        private val horizontalLine: View = itemView.horizontal_line
    ) : RecyclerView.ViewHolder(itemView) {

        fun bind(listItemData: DetailsViewTypeDescription) {
            detailsH1.text = listItemData.workHistoryDetails.title
            detailsH2.text = listItemData.workHistoryDetails.subtitle
            detailsH3.text = listItemData.workHistoryDetails.details
            if (listItemData.isLast) {
                (horizontalLine.layoutParams as ConstraintLayout.LayoutParams).bottomMargin = 50
                (cardView.layoutParams as FrameLayout.LayoutParams).bottomMargin = 0
            } else {
                (horizontalLine.layoutParams as ConstraintLayout.LayoutParams).bottomMargin = 0
                (cardView.layoutParams as FrameLayout.LayoutParams).bottomMargin = -50
            }
        }
    }
}