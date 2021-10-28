package com.my.news.headlinenews

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.my.network.bean.ProjectBean

class HeadlineNewsViewModel : ViewModel() {
    var projectList=MutableLiveData<List<ProjectBean>>()


}