package com.lyw.lyw_home.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import com.lyw.lyw_common.base.viewmodel.BaseViewModel

/**
 * 功能描述:
 * Created on 2021/4/13.
 * @author lyw
 */
class HomeViewModel(private val savedStateHandle: SavedStateHandle) :BaseViewModel(){
    private val HOME_PAGE_INDEX = "home_page_index"
    private val mLiveData = MutableLiveData<Int>()

    //从缓存中读取，防止Activity因内存不知等原因被回收重建后，Fragment重叠问题
    fun getSelect():LiveData<Int>{
        if (mLiveData.value == null) {
            val index = savedStateHandle.get<Int>(HOME_PAGE_INDEX) ?: 0
            mLiveData.value = index
        }
        return mLiveData
    }

    //保存每一次的下标选中
    fun saveSelect(selectIndex :Int){
        savedStateHandle.set(HOME_PAGE_INDEX,selectIndex)
    }
}