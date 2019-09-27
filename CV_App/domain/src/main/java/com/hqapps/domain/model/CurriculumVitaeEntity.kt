package com.hqapps.domain.model

data class WorkHistoryDetails(
    val title: String,
    val subtitle: String,
    val details: String
)

data class WorkHistory(
    val title: String,
    val details: ArrayList<WorkHistoryDetails>
)

data class CurriculumVitaeEntity(
    val title: String, val about: String, val photo_url: String, val work_history: ArrayList<WorkHistory>
)