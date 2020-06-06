package io.github.dvegasa.rutech.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * Created by Ed Khalturin @DVegasa
 */
class MainViewModel : ViewModel() {

    val curScreen = MutableLiveData(1)
}