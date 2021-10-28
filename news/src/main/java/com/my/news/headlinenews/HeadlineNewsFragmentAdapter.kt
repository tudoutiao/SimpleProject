package com.my.news.headlinenews

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.my.news.newslist.NewsListFragment

class HeadlineNewsFragmentAdapter(fm: FragmentManager, fragment: Fragment) :
    FragmentStateAdapter(fragment) {
    override fun getItemCount(): Int {
        return 10
    }

    override fun createFragment(position: Int): Fragment {
        val fratment = NewsListFragment.newInstance("", "")
        return fratment
    }



}