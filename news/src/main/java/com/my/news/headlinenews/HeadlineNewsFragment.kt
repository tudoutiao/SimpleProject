package com.my.news.headlinenews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.tabs.TabLayoutMediator
import com.my.news.R
import com.my.news.databinding.FragmentHeadlineNewsBinding

class HeadlineNewsFragment : Fragment() {

    companion object {
        fun newInstance() = HeadlineNewsFragment()
    }

    lateinit var viewModel: HeadlineNewsViewModel
    lateinit var fragmentAdapter: HeadlineNewsFragmentAdapter
    lateinit var viewBinding: FragmentHeadlineNewsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewBinding = FragmentHeadlineNewsBinding.bind(
            inflater.inflate(
                R.layout.fragment_headline_news,
                container,
                false
            )
        )
        return viewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(HeadlineNewsViewModel::class.java)
        fragmentAdapter = HeadlineNewsFragmentAdapter(childFragmentManager, this)
        viewBinding.container.adapter = fragmentAdapter
        TabLayoutMediator(viewBinding.tablayout, viewBinding.container) { tab, position ->
            {
                tab.text = "第${position}"
            }
        }.attach()

    }

}