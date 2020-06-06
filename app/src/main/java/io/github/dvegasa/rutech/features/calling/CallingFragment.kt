package io.github.dvegasa.rutech.features.calling

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import io.github.dvegasa.rutech.R
import kotlinx.android.synthetic.main.calling_fragment.*

const val ARG_ROOM_ID = "roomId"
const val ROOM_ID_ERROR = -404

class CallingFragment : DialogFragment() {

    private var roomId: Int = -1

    companion object {
        fun newInstance(roomId: Int): CallingFragment {
            val args = Bundle()
            args.putInt(ARG_ROOM_ID, roomId)
            val frag = CallingFragment()
            frag.arguments = args
            return frag
        }
    }

    private lateinit var viewModel: CallingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.calling_fragment, container, false)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NORMAL, android.R.style.Theme_Black_NoTitleBar_Fullscreen)
        roomId = arguments?.getInt(ARG_ROOM_ID) ?: ROOM_ID_ERROR
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CallingViewModel::class.java)
        tvRoomId.text = roomId.toString()
    }


}
