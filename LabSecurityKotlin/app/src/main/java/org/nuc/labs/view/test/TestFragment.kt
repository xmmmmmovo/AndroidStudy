package org.nuc.labs.view.test

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels

import org.nuc.labs.R
import org.nuc.labs.databinding.TestFragmentBinding

class TestFragment : Fragment() {

    companion object {
        fun newInstance() = TestFragment()
    }

    private val TestViewModel by viewModels<TestViewModel>()
    private lateinit var binding: TestFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TestFragmentBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

}
