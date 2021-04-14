package com.lyw.lyw_weather.fragment

import com.alibaba.android.arouter.facade.annotation.Route
import com.lyw.lyw_common.base.fragment.BaseVmDbFragment
import com.lyw.lyw_provider.router.RouterPath
import com.lyw.lyw_weather.R
import com.lyw.lyw_weather.databinding.WeatherFragmentBinding

/**
 * 功能描述:天气fragment
 * Created on 2021/4/14.
 * @author lyw
 */
@Route(path = RouterPath.Weather.PATH_WEATHER_HOME)
class WeatherFragment :BaseVmDbFragment<WeatherViewModel,WeatherFragmentBinding>(){
    override fun layoutId(): Int = R.layout.weather_fragment

    override fun lazyLoadData() {
    }

    override fun initView() {
    }

    override fun createObserver() {
    }
}