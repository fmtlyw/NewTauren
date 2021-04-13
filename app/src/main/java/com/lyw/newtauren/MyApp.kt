package com.lyw.newtauren

import com.alibaba.android.arouter.launcher.ARouter
import com.lyw.lyw_common.BaseApp
import com.lyw.lyw_common.BuildConfig
import com.lyw.lyw_common.global.Configurator
import com.tencent.mmkv.MMKV

/**
 * 功能描述:
 * Created on 2021/4/13.
 * @author lyw
 */
class MyApp : BaseApp() {
    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            ARouter.openDebug()
        }

        Configurator.instance.withWebApiHost("http://baobab.kaiyanapp.com/api/").configure()

        MMKV.initialize(this)
        //初始化路由
        ARouter.init(this)
    }

}