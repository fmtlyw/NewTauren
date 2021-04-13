package com.lyw.newtauren

import android.app.Application
import com.alibaba.android.arouter.launcher.ARouter

/**
 * 功能描述:
 * Created on 2021/4/12.
 * @author lyw
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        ARouter.init(this)
    }
}