package com.lyw.lyw_project.fragment
import com.lyw.lyw_common.base.fragment.BaseVmDbFragment
import com.lyw.lyw_project.R
import com.lyw.lyw_project.databinding.FragmentFollowBinding
import com.lyw.lyw_project.viewmodel.FollowViewModel

/**
 * 功能描述:关注页面
 * Created on 2021/4/14.
 * @author lyw
 */
class FollowFragment :BaseVmDbFragment<FollowViewModel,FragmentFollowBinding>(){
    override fun layoutId(): Int = R.layout.fragment_follow

    override fun lazyLoadData() {
    }

    override fun initView() {
    }

    override fun createObserver() {
    }
}