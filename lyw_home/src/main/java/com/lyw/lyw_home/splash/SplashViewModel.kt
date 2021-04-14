package com.lyw.lyw_home.splash

import com.lyw.lyw_common.base.viewmodel.BaseViewModel
import com.lyw.lyw_common.databind.IntObservableField
import com.lyw.lyw_common.databind.StringObservableField

/**
 * 功能描述:
 * Created on 2021/4/13.
 * @author lyw
 */
class SplashViewModel :BaseViewModel(){

    var splashNameEn = StringObservableField()
    var splashNameCn = StringObservableField()

    var splashImageS = IntObservableField()

    var splashImageB = IntObservableField()
}