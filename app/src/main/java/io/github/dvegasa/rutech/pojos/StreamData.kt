package io.github.dvegasa.rutech.pojos

/**
 * Created by Ed Khalturin @DVegasa
 */
data class StreamData (
    val title: String,
    val speaker: String,
    val time: String,
    val ava: Int,
    val avaUrl: String? = null
)