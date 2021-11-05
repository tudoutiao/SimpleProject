package com.my.news.headlinenews

import androidx.lifecycle.MutableLiveData
import com.my.base.base.BaseViewModel
import com.my.network.bean.ProjectBean

class HeadlineNewsViewModel : BaseViewModel() {
    var projectList = MutableLiveData<List<ProjectBean>>()


}