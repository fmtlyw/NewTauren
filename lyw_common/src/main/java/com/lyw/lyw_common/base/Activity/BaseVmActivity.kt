package com.lyw.lyw_common.base.Activity

import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.gyf.immersionbar.ImmersionBar
import com.lyw.lyw_common.R
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
abstract class BaseVmActivity<VM : BaseViewModel> : AppCompatActivity() {
    /**
     * 是否需要使用DataBinding 供子类BaseVmDbActivity修改，用户请慎动
     */
    private var isUserDb = false

    lateinit var mViewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (!isUserDb) {
            setContentView(layoutId())
        } else {
            initDataBind()
        }
        initView()
        init(savedInstanceState)
        createObserver()
        initData()
    }

    private fun init(savedInstanceState: Bundle?) {
        mViewModel = createViewModel()
        mViewModel.mStateLiveData.observe(this, Observer{ state ->
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

        setStatusBarBackground(R.color.colorPrimaryDark)
    }

    private fun createViewModel(): VM {
        return ViewModelProvider(this).get(getVmClazz(this))
    }

    /**
     * 供子类BaseVmDbActivity 初始化Databinding操作
     */
    open fun initDataBind() {}

    abstract fun layoutId(): Int

    fun userDataBinding(isUserDb: Boolean) {
        this.isUserDb = isUserDb
    }


    //由于每个页面的加载框可能不一致，所以此处暴露给子类实现
    open fun showLoading() {

    }

    open fun hideLoading() {

    }

    open fun handlerError() {

    }

    abstract fun initView()

    abstract fun initData()

    abstract fun createObserver()

    /**
     * 设置状态栏背景色
     */
    open fun setStatusBarBackground(@ColorRes statusBarColor: Int) {
        ImmersionBar.with(this).autoStatusBarDarkModeEnable(true, 0.2f).statusBarColor(statusBarColor).fitsSystemWindows(true).init()
    }
}