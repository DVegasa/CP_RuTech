package io.github.dvegasa.rutech.pojos

/**
 * Created by Ed Khalturin @DVegasa
 */
data class UserData (
    val id: Int,
    val name: String,
    val ava: Int = id
)