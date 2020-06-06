package io.github.dvegasa.rutech.features

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem
import io.github.dvegasa.rutech.R
import io.github.dvegasa.rutech.features.livestreams.LivestreamsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var vm: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vm = ViewModelProvider(this).get(MainViewModel::class.java)
        initBnav()
    }

    private fun initBnav() {
        val item0 = AHBottomNavigationItem("Search", R.drawable.ic_search)
        val item1 = AHBottomNavigationItem("Streams", R.drawable.ic_livestreams)
        val item2 = AHBottomNavigationItem("Contacts", R.drawable.ic_contacts)

        bnav.addItem(item0)
        bnav.addItem(item1)
        bnav.addItem(item2)

        bnav.defaultBackgroundColor = Color.parseColor("#000000")
        bnav.accentColor = Color.parseColor("#FFEE29")
        bnav.titleState = AHBottomNavigation.TitleState.ALWAYS_HIDE
        bnav.currentItem = vm.curScreen.value ?: 1
        bnav.setOnTabSelectedListener { position, wasSelected ->
            vm.curScreen.value = position
            true
        }
    }
}
