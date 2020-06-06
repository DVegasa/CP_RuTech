package io.github.dvegasa.rutech.features.livestreams

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import io.github.dvegasa.rutech.R
import io.github.dvegasa.rutech.features.MainViewModel
import io.github.dvegasa.rutech.features.calling.CallingFragment
import io.github.dvegasa.rutech.network.FakeRepo
import kotlinx.android.synthetic.main.livestreams_fragment.*

class LivestreamsFragment : Fragment() {

    companion object {
        fun newInstance() = LivestreamsFragment()
    }

    private lateinit var vm: LivestreamsViewModel
    private lateinit var vmMain: MainViewModel

    private lateinit var adapter: RvStreamsAdapter

    var callingFragment: CallingFragment? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.livestreams_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        vm = ViewModelProvider(this).get(LivestreamsViewModel::class.java)
        initRvStreams()
    }

    private fun initRvStreams() {
        val list = FakeRepo.streams
        adapter = RvStreamsAdapter(viewLifecycleOwner, list) {pos ->
            callingFragment = CallingFragment.newInstance(list.value?.get(pos)?.id ?: -1)
            callingFragment!!.show(childFragmentManager, "calling")
        }
        rvStreams.layoutManager = LinearLayoutManager(context)
        rvStreams.adapter = adapter
    }

}
