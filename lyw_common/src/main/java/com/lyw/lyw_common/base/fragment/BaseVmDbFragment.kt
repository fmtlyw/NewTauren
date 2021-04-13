package com.lyw.lyw_common.base.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import com.lyw.lyw_common.base.viewmodel.BaseViewModel

/**
 * 功能描述:
 * Created on 2021/4/13.
 * @author lyw
 */
abstract class BaseVmDbFragment<VM : BaseViewModel ,DB: ViewDataBinding>:BaseVmFragment<VM>() {
    lateinit var mDataBind : DB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mDataBind = DataBindingUtil.inflate(inflater,layoutId(),container,false)
        mDataBind.lifecycleOwner = this
        return mDataBind.root
    }

}