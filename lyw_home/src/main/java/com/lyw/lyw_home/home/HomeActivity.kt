package com.lyw.lyw_home.home
import android.content.Context
import android.content.Intent
import com.lyw.lyw_common.base.Activity.BaseVmActivity
import com.lyw.lyw_home.R

/**
 * 功能描述:主界面（首页)
 * Created on 2021/4/13.
 * @author lyw
 */
class HomeActivity : BaseVmActivity<HomeViewModel>(){


    companion object {

        fun start(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    override fun layoutId(): Int = R.layout.home_activity_home

    override fun initView() {
    }

    override fun initData() {
    }

    override fun createObserver() {
    }
}