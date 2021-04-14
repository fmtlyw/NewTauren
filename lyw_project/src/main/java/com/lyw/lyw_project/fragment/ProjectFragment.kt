package com.lyw.lyw_project.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.lyw.lyw_common.base.fragment.BaseVmDbFragment
import com.lyw.lyw_project.ProjectViewModel
import com.lyw.lyw_project.R
import com.lyw.lyw_project.databinding.ProjectFragmentBinding
import com.lyw.lyw_provider.router.RouterPath

/**
 * 功能描述:项目页面
 * Created on 2021/4/14.
 * @author lyw
 */
@Route(path = RouterPath.Project.PATH_PROJECT_HOME)
class ProjectFragment :BaseVmDbFragment<ProjectViewModel,ProjectFragmentBinding>() {
    override fun layoutId(): Int = R.layout.project_fragment

    override fun lazyLoadData() {
    }

    override fun initView() {
    }

    override fun createObserver() {
    }
}