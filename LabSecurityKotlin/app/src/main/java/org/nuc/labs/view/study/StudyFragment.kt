package org.nuc.labs.view.study

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import org.nuc.labs.R
import org.nuc.labs.databinding.StudyFragmentBinding

class StudyFragment : Fragment() {

    companion object {
        fun newInstance() = StudyFragment()
    }

    private val studyViewModel by viewModels<StudyViewModel>()
    private lateinit var binding: StudyFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = StudyFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
