package com.hqapps.cvapp.ui.main.curriculumvitaedetails

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import com.hqapps.cvapp.R
import com.hqapps.cvapp.databinding.FragmentCurriculumVitaeDetailsBinding
import com.hqapps.cvapp.ui.base.BaseFragment
import javax.inject.Inject

class CurriculumVitaeDetailsFragment :
    BaseFragment<CurriculumVitaeViewModel, FragmentCurriculumVitaeDetailsBinding>(
        R.layout.fragment_curriculum_vitae_details
    ) {

    @Inject
    lateinit var curriculumVitaeViewModel: CurriculumVitaeViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        curriculumVitaeViewModel.errorMessageId.observe(viewLifecycleOwner, Observer {
            Toast.makeText(requireContext(), getText(it), Toast.LENGTH_SHORT).show()
        })
    }

}