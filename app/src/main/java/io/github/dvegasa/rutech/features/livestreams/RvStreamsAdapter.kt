package io.github.dvegasa.rutech.features.livestreams

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.RecyclerView
import io.github.dvegasa.rutech.R
import io.github.dvegasa.rutech.network.FakeRepo
import io.github.dvegasa.rutech.pojos.StreamData
import kotlinx.android.synthetic.main.item_stream.view.*

/**
 * Created by Ed Khalturin @DVegasa
 */
class RvStreamsAdapter(val lifecycleOwner: LifecycleOwner, val list: LiveData<List<StreamData>>) :
    RecyclerView.Adapter<RvStreamsAdapter.VH>() {

    init {
        list.observe(lifecycleOwner, Observer {
            notifyDataSetChanged()
        })
    }

    inner class VH(val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(pos: Int) {
            val data = list.value?.get(pos)
            data?.let {
                view.apply {
                    tvTitle.text = data.title
                    tvTime.text = data.time
                    tvSpeaker.text = data.speaker
                    ivAva.setImageResource(FakeRepo.avaMap.getValue(data.ava))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_stream, parent, false)
        return VH(v)
    }

    override fun getItemCount() = list.value?.size ?: 0

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(position)
    }
}