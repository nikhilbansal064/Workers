package com.example.nikhil.workers.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.nikhil.workers.view.SectionListFragment
import com.example.nikhil.workers.view.SimpleListFragment

class WorkerPagerAdapter(val fragmentManager: FragmentManager, val tabCount: Int) :
        FragmentPagerAdapter(fragmentManager) {

    // 2
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> SimpleListFragment.newInstance()
            1 -> SectionListFragment.newInstance()
            else -> SimpleListFragment.newInstance()
        }
    }


    override fun getCount(): Int {
        return tabCount
    }
}