package io.github.dvegasa.rutech.features

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.dvegasa.rutech.features.contacts.ContactsFragment
import io.github.dvegasa.rutech.features.livestreams.LivestreamsFragment
import io.github.dvegasa.rutech.features.search.SearchFragment

/**
 * Created by Ed Khalturin @DVegasa
 */
class MainViewModel : ViewModel() {

    val fragSearch = SearchFragment.newInstance()
    val fragStreams = LivestreamsFragment.newInstance()
    val fragContacts = ContactsFragment.newInstance()

    val curScreen = MutableLiveData(1)
}