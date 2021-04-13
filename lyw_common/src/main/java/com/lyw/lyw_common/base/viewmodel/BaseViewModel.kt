package com.lyw.lyw_common.base.viewmodel

import androidx.lifecycle.LiveDataScope
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import java.lang.Exception

/**
 * 功能描述:
 * Created on 2021/4/13.
 * @author lyw
 */
open class BaseViewModel : ViewModel() {
    val mStateLiveData = MutableLiveData<State>()

    fun <T> liveDataEx(block: suspend LiveDataScope<T>.() -> T) = liveData {
        try {
            mStateLiveData.postValue(LoadState)
            emit(block())
            mStateLiveData.postValue(SuccessState)
        } catch (e: Exception) {
            mStateLiveData.postValue(ErrorState(e.message))
        }
    }
}

sealed class State

object LoadState : State()

object SuccessState : State()

class ErrorState(val errorMsg: String?) : State()
