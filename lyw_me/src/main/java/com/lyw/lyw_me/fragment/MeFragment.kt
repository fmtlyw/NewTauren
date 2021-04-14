package com.lyw.lyw_me.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.lyw.lyw_common.base.fragment.BaseVmDbFragment
import com.lyw.lyw_me.MeViewModel
import com.lyw.lyw_me.R
import com.lyw.lyw_me.databinding.MeFragmentBinding
import com.lyw.lyw_provider.router.RouterPath

/**
 * 功能描述:我的
 * Created on 2021/4/14.
 * @author lyw
 */
@Route(path = RouterPath.Person.PATH_PERSON_HOME)
class MeFragment :BaseVmDbFragment<MeViewModel,MeFragmentBinding>(){
    override fun layoutId(): Int = R.layout.me_fragment

    override fun lazyLoadData() {
    }

    override fun initView() {
    }

    override fun createObserver() {
    }
}