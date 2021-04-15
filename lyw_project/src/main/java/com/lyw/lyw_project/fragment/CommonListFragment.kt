package com.lyw.lyw_project.fragment

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.listener.OnItemClickListener
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyw.lyw_common.base.fragment.BaseVmFragment
import com.lyw.lyw_project.R
import com.lyw.lyw_project.viewmodel.CommonListViewModel
import kotlinx.android.synthetic.main.project_fragment_commonlist.*

/**
 * 功能描述:项目页面的基类
 * Created on 2021/4/14.
 * @author lyw
 */
abstract class CommonListFragment<VM : CommonListViewModel, M> :
    BaseVmFragment<CommonListViewModel>(),
    OnItemClickListener {

    private var mIsLoadMore = false

    lateinit var mAdapter: BaseQuickAdapter<M, BaseViewHolder>

    override fun layoutId(): Int = R.layout.project_fragment_commonlist

    override fun lazyLoadData() {
        getListData(true)
    }

    override fun initView() {
        mSwipeRefreshLayout.apply {
            isRefreshing = true
            setOnRefreshListener {
                lazyLoadData()
            }
        }

        mRecyclerView.layoutManager = LinearLayoutManager(context)
        mAdapter = getAdapter()
        mAdapter.setOnItemClickListener(this)
        mAdapter.loadMoreModule.setOnLoadMoreListener {
            mIsLoadMore = true
            getListData()
        }
        mRecyclerView.adapter = mAdapter
    }

    private fun getListData(firstPage: Boolean = false) {
        mViewModel.getListData<M>(firstPage).observe(viewLifecycleOwner, Observer {
            if (it.isNotEmpty()) {
                if (firstPage) {
                    mAdapter.setList(it)
                }else{
                    mAdapter.addData(it)
                    mAdapter.loadMoreModule.loadMoreComplete()
                }
            }else{
                if (mViewModel.mNextPageUrl == null) {
                    mAdapter.loadMoreModule.loadMoreEnd()
                }else{
                    mAdapter.loadMoreModule.loadMoreComplete()
                }
            }
        })
    }

    abstract fun getAdapter(): BaseQuickAdapter<M, BaseViewHolder>

    override fun createObserver() {
    }

    override fun onItemClick(adapter: BaseQuickAdapter<*, *>, view: View, position: Int) {

    }

    override fun hideLoading() {
        mSwipeRefreshLayout.isRefreshing = false
    }

    override fun handlerError() {
        if (mIsLoadMore) {
            mAdapter.loadMoreModule.loadMoreFail()
        }
    }
}