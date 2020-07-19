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

data class Address(
    val line1: String,
    val line2: String
)

data class Skill(
    val name: String,
    val percentage: Int
)

data class CurriculumVitaeEntity(
    val title: String,
    val subtitle: String,
    val about: String,
    val age: Int,
    val email: String,
    val phone: String,
    val date_of_birth: String,
    val nationality: String,
    val linkedin_url: String,
    val github_url: String,
    val photo_url: String,
    val address: Address,
    val work_history: ArrayList<WorkHistory>,
    val skills: ArrayList<Skill>,
    val interests: ArrayList<String>,
    val additional_informations: ArrayList<String>
)