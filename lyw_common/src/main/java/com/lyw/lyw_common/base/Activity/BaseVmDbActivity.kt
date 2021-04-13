package com.lyw.lyw_common.base.Activity

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lyw.lyw_common.base.viewmodel.BaseViewModel

/**
 * 功能描述:
 * Created on 2021/4/13.
 * @author lyw
 */
abstract class BaseVmDbActivity<VM : BaseViewModel, DB : ViewDataBinding> : BaseVmActivity<VM>() {
    lateinit var mDataBind: DB
    override fun onCreate(savedInstanceState: Bundle?) {
        userDataBinding(true)
        super.onCreate(savedInstanceState)
    }

    override fun initDataBind() {
        mDataBind = DataBindingUtil.setContentView(this,layoutId())
        mDataBind.lifecycleOwner = this
    }
}