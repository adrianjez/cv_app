package com.hqapps.cvapp.ui.main.curriculumvitaedetails

import com.hqapps.domain.model.WorkHistoryDetails

abstract class ViewType (val viewTypeID: Int)

class AboutViewType(viewTypeID: Int): ViewType(viewTypeID)
class DetailsViewTypeTitle(viewTypeID: Int, val title: String): ViewType(viewTypeID)
class DetailsViewTypeSubtitle(viewTypeID: Int, val subtitle: String): ViewType(viewTypeID)
class DetailsViewTypeDescription(viewTypeID: Int, val workHistoryDetails: WorkHistoryDetails): ViewType(viewTypeID)
