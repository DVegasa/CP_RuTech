package io.github.dvegasa.rutech.features.livestreams

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import io.github.dvegasa.rutech.R

class LivestreamsFragment : Fragment() {

    companion object {
        fun newInstance() = LivestreamsFragment()
    }

    private lateinit var vm: LivestreamsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.livestreams_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm = ViewModelProvider(this).get(LivestreamsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
