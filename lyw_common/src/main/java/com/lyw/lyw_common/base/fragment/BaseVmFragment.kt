package com.lyw.lyw_common.base.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.lyw.lyw_common.base.viewmodel.BaseViewModel
import com.lyw.lyw_common.base.viewmodel.ErrorState
import com.lyw.lyw_common.base.viewmodel.LoadState
import com.lyw.lyw_common.base.viewmodel.SuccessState
import com.lyw.lyw_common.ext.errorToast
import com.lyw.lyw_common.ext.getVmClazz


/**
 * 功能描述:
 * Created on 2021/4/13.
 * @author lyw
 */
abstract class BaseVmFragment<VM : BaseViewModel> : Fragment() {

    //是否第一次加载
    private var isFirst: Boolean = true

    abstract fun layoutId(): Int

    lateinit var mActivity: AppCompatActivity

    lateinit var mViewModel:VM

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(layoutId(), container, false)
    }


    override fun onAttach(context: Context) {
        super.onAttach(context)
        mActivity = context as AppCompatActivity
    }

    override fun onResume() {
        super.onResume()
        if (lifecycle.currentState == Lifecycle.State.STARTED && isFirst) {
//等待view加载后触发懒加载
            view?.post {
                lazyLoadData()

                isFirst = false
            }
        }
    }

    abstract fun lazyLoadData()
    abstract fun initView()
    abstract fun createObserver()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mViewModel = createViewModel()
        mViewModel.mStateLiveData.observe(viewLifecycleOwner, Observer{ state ->
            when (state) {
                LoadState -> {
                    showLoading()
                }
                SuccessState -> {
                    hideLoading()
                }
                is ErrorState -> {
                    hideLoading()
                    state.errorMsg?.let { errorToast(it) }
                    handlerError()
                }
            }
        })
        initView()
        createObserver()
    }

    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }

    //由于每个页面的加载框可能不一致，所以此处暴露给子类实现
    open fun showLoading() {

    }

    open fun hideLoading() {

    }

    open fun handlerError() {

    }

}