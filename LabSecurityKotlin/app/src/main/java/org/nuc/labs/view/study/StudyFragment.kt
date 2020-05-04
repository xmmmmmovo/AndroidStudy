package org.nuc.labs.view.study

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.nuc.labs.R

class StudyFragment : Fragment() {

    companion object {
        fun newInstance() = StudyFragment()
    }

    private lateinit var viewModel: StudyViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.study_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StudyViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
