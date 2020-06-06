package io.github.dvegasa.rutech.features.calling

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import io.github.dvegasa.rutech.R

class CallingFragment : Fragment() {

    companion object {
        fun newInstance() = CallingFragment()
    }

    private lateinit var viewModel: CallingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.calling_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(CallingViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
