package io.github.dvegasa.rutech.features.calling

import android.app.Dialog
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import io.github.dvegasa.rutech.R
import io.github.dvegasa.rutech.network.FakeRepo
import io.github.dvegasa.rutech.pojos.UserData
import kotlinx.android.synthetic.main.calling_fragment.*
import kotlinx.android.synthetic.main.item_user.view.*
import kotlin.random.Random

const val ARG_ROOM_ID = "roomId"
const val ROOM_ID_ERROR = -404

class CallingFragment : DialogFragment() {

    private var roomId: Int = -1


    val callers = MutableLiveData(randomCallers())

    private fun randomCallers(): ArrayList<UserData> {
        val list = arrayListOf<UserData>()
        val n = listOf(0, 1, 2, 3, 4).shuffled()[0]
        val users = FakeRepo.users.toList().shuffled()
        for (i in 0..n) {
            list.add(users[i])
        }
        Log.d("ed_", "randomized list.size = ${list.size}")
        return list
    }


    companion object {
        fun newInstance(roomId: Int): CallingFragment {
            val args = Bundle()
            args.putInt(ARG_ROOM_ID, roomId)
            val frag = CallingFragment()
            frag.arguments = args
            return frag
        }
    }

    private lateinit var vm: CallingViewModel

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
        vm = ViewModelProvider(this).get(CallingViewModel::class.java)
        defineCallers()
        initPtt()
        randomCallers()
    }

    private fun initPtt() {
        ivPtt.setOnTouchListener { view, motionEvent ->
            if (motionEvent.action == MotionEvent.ACTION_DOWN) {
                user0.ivYellow.visibility = View.VISIBLE
                user0.tvName.setTextColor(resources.getColor(R.color.yellow))
                ivPtt.setImageResource(R.drawable.ic_ptt_active)

            } else if (motionEvent.action == MotionEvent.ACTION_UP) {
                user0.ivYellow.visibility = View.INVISIBLE
                ivPtt.setImageResource(R.drawable.ic_ptt)
                user0.tvName.setTextColor(resources.getColor(R.color.white))
            }
            true
        }
    }

    private fun defineCallers() {
        callers.observe(viewLifecycleOwner, Observer { users ->
            Log.d("ed__", "defineCallers: callers.size = ${users.size}")
            val userViews = arrayListOf<View>()
            for (u in users) {
                userViews.add(userDataToView(u))
            }
            Log.d("ed__", "defineCallers: userViews.size = ${userViews.size}")

            // 0 1 2
            //  3 4
            for (i in userViews.indices) {
                if (i <= 2) {
                    Log.d("ed__", "adding top")
                    llTopPanel.addView(userViews[i])
                } else {
                    Log.d("ed__", "adding bottom")
                    llBottomPanel.addView(userViews[i])
                }
            }
        })
    }

    private fun userDataToView(u: UserData): View {
        val v = LayoutInflater.from(context).inflate(R.layout.item_user, llTopPanel, false)
        v.ivAva.setImageResource(FakeRepo.avaMap.getValue(u.id))
        v.tvName.text = u.name
        return v
    }
}
