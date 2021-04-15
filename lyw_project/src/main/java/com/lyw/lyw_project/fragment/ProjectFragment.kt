package com.lyw.lyw_project.fragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentStatePagerAdapter
import com.alibaba.android.arouter.facade.annotation.Route
import com.lyw.lyw_common.base.fragment.BaseVmFragment
import com.lyw.lyw_project.R
import com.lyw.lyw_project.viewmodel.ProjectViewModel
import com.lyw.lyw_provider.router.RouterPath
import kotlinx.android.synthetic.main.project_fragment.*

/**
 * 功能描述:项目页面
 * Created on 2021/4/14.
 * @author lyw
 */
@Route(path = RouterPath.Project.PATH_PROJECT_HOME)
class ProjectFragment : BaseVmFragment<ProjectViewModel>() {

    private val mTabTitleList :Array<String> by lazy { resources.getStringArray(R.array.project_titles) }

    private val mFragmentList by lazy {
        mutableListOf<Fragment>().apply {
            add(CategoryFragment())
            add(FollowFragment())
        }
    }

    override fun layoutId(): Int = R.layout.project_fragment

    override fun lazyLoadData() {
    }

    override fun initView() {
        //如果ViewPage2这里需要处理两种冲突：
        //1.横向RecyclerView与ViewPage2的滑动冲突
        //2.垂直方向RecyclerView与横向RecyclerView的滑动冲突
        //比较麻烦，所以此处采用了ViewPager
        mViewPager.adapter = object :FragmentStatePagerAdapter(childFragmentManager,BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
            override fun getItem(position: Int): Fragment = mFragmentList[position]

            override fun getCount(): Int = mFragmentList.size

            override fun getPageTitle(position: Int) = mTabTitleList[position]
        }
        mTabLayout.setupWithViewPager(mViewPager)
    }

    override fun createObserver() {
    }
}