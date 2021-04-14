package com.lyw.lyw_project.fragment

import com.lyw.lyw_common.base.fragment.BaseVmDbFragment
import com.lyw.lyw_project.R
import com.lyw.lyw_project.databinding.FragmentCategoryBinding
import com.lyw.lyw_project.viewmodel.CategoryViewModel


/**
 * 功能描述:分类页面
 * Created on 2021/4/14.
 * @author lyw
 */
class CategoryFragment :BaseVmDbFragment<CategoryViewModel,FragmentCategoryBinding>() {
    override fun layoutId(): Int = R.layout.fragment_category

    override fun lazyLoadData() {
    }

    override fun initView() {
    }

    override fun createObserver() {
    }
}