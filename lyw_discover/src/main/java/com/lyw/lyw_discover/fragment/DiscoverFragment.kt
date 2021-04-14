package com.lyw.lyw_discover.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.lyw.lyw_common.base.fragment.BaseVmDbFragment
import com.lyw.lyw_discover.DiscoverViewModel
import com.lyw.lyw_discover.R
import com.lyw.lyw_discover.databinding.DiscoverFragmentBinding
import com.lyw.lyw_provider.router.RouterPath

/**
 * 功能描述:发现页面
 * Created on 2021/4/14.
 * @author lyw
 */
@Route(path = RouterPath.Discover.PATH_DISCOVER_HOME)
class DiscoverFragment :BaseVmDbFragment<DiscoverViewModel, DiscoverFragmentBinding>(){
    override fun layoutId(): Int = R.layout.discover_fragment

    override fun lazyLoadData() {
    }

    override fun initView() {
    }

    override fun createObserver() {
    }
}