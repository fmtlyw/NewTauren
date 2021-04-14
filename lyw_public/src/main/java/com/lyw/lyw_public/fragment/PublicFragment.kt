package com.lyw.lyw_public.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.lyw.lyw_common.base.fragment.BaseVmDbFragment
import com.lyw.lyw_provider.router.RouterPath
import com.lyw.lyw_public.PublicViewModel
import com.lyw.lyw_public.R
import com.lyw.lyw_public.databinding.PublicFragmentBinding

/**
 * 功能描述:
 * Created on 2021/4/14.
 * @author lyw
 */
@Route(path = RouterPath.Public.PATH_PUBLIC_HOME)
class PublicFragment : BaseVmDbFragment<PublicViewModel,PublicFragmentBinding>(){
    override fun layoutId(): Int = R.layout.public_fragment

    override fun lazyLoadData() {
    }

    override fun initView() {
    }

    override fun createObserver() {
    }
}