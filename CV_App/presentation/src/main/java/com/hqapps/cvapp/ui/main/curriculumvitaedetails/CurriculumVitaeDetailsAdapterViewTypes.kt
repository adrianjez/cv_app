package com.hqapps.cvapp.ui.main.curriculumvitaedetails

import com.hqapps.domain.model.Skill
import com.hqapps.domain.model.WorkHistoryDetails

abstract class ViewType(val viewTypeID: Int)

class ProfileViewType(
    viewTypeID: Int,
    val imageUrl: String,
    val displayName: String,
    val displayTitle: String
) : ViewType(viewTypeID)

class AboutViewType(
    viewTypeID: Int,
    val about: String,
    val age: String,
    val addressLine1: String,
    val addressLine2: String,
    val email: String,
    val phone: String,
    val dateOfBirth: String
) : ViewType(viewTypeID)

class DetailsViewTypeTitle(
    viewTypeID: Int,
    val title: String
) : ViewType(viewTypeID)

class DetailsViewTypeSubtitle(
    viewTypeID: Int,
    val subtitle: String
) : ViewType(viewTypeID)

class DetailsViewTypeDescription(
    viewTypeID: Int,
    val workHistoryDetails: WorkHistoryDetails,
    val isLast: Boolean
) : ViewType(viewTypeID)

class SkillViewType(
    viewTypeID: Int,
    val skill: Skill,
    val isLast: Boolean
) : ViewType(viewTypeID)
