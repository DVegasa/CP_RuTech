package io.github.dvegasa.rutech.network

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.github.dvegasa.rutech.R
import io.github.dvegasa.rutech.pojos.StreamData

/**
 * Created by Ed Khalturin @DVegasa
 */

object FakeRepo {

    val avaMap = mapOf(
        0 to R.drawable.face0,
        1 to R.drawable.face1,
        2 to R.drawable.face2,
        3 to R.drawable.face3,
        4 to R.drawable.face4
    )

    val streams = MutableLiveData(
        listOf(
            StreamData(
                0,
                "Home matters: Spatial Computing in everyday spaces",
                "EDUARD KHALTURIN",
                "15:00 - 15:50",
                0
            ), StreamData(
                1,
                "Transforming Online Learning: Covid-19 and Beyond",
                "SHRAVAN GOLI ",
                "16:00 - 16:50",
                1
            ), StreamData(
                2,
                "Making cool android apps in 2k20",
                "ELENA VOLKOVA",
                "16:00 - 16:50",
                4
            )
        )
    )
}