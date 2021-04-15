package com.lyw.lyw_project.viewmodel

import androidx.lifecycle.LiveData
import com.lyw.lyw_common.base.viewmodel.BaseViewModel

/**
 * 功能描述:
 * Created on 2021/4/14.
 * @author lyw
 */
abstract class CommonListViewModel : BaseViewModel() {
    var mNextPageUrl: String? = null

    fun <M> getListData(firstPage: Boolean): LiveData<List<M>> = liveDataEx {
        if (mNextPageUrl == null && !firstPage) {
            mutableListOf()
        } else {
            mutableListOf()
//            if (firstPage) {
//                getRefreshList()
//            }else{
//                getLoadMoreList()
//            }
        }
    }

    abstract fun getRefreshList()

    abstract fun getLoadMoreList()
}