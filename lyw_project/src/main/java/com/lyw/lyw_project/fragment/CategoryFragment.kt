package com.lyw.lyw_project.fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lyw.lyw_common.base.fragment.BaseVmFragment
import com.lyw.lyw_project.R
import com.lyw.lyw_project.adapter.CategoryAdapter
import com.lyw.lyw_project.viewmodel.CategoryViewModel
import kotlinx.android.synthetic.main.project_fragment_commonlist.*

/**
 * 功能描述:分类页面
 * Created on 2021/4/14.
 * @author lyw
 */
class CategoryFragment :BaseVmFragment<CategoryViewModel>(){

    private var mIsLoadMore = false

    private val mAdapter:CategoryAdapter by lazy { CategoryAdapter(mActivity,this) }

    override fun layoutId(): Int = R.layout.project_fragment_commonlist

    override fun lazyLoadData() {
    }

    override fun initView() {
        mSwipeRefreshLayout.isRefreshing = true
        mSwipeRefreshLayout.setOnRefreshListener {
            mIsLoadMore = false

        }
        mRecyclerView.layoutManager = LinearLayoutManager(mActivity)
        mRecyclerView.adapter = mAdapter

    }

    override fun createObserver() {
        mViewModel.getBanner().observe(viewLifecycleOwner, Observer {
            mAdapter.setList(mutableListOf())
            mAdapter.addData(it)
        })
    }

    override fun hideLoading() {
        mSwipeRefreshLayout.isRefreshing = false
    }

}