package com.lyw.lyw_home.home

import android.content.Context
import android.content.Intent
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.lifecycle.Observer
import com.alibaba.android.arouter.launcher.ARouter
import com.lyw.lyw_common.base.activity.BaseVmActivity
import com.lyw.lyw_home.R
import com.lyw.lyw_provider.router.RouterPath
import kotlinx.android.synthetic.main.home_activity_home.*

/**
 * 功能描述:主界面（首页)
 * Created on 2021/4/13.
 * @author lyw
 */
class HomeActivity : BaseVmActivity<HomeViewModel>() {

    private var mWeatherFragment: Fragment? = null
    private var mDiscoveryFragment: Fragment? = null
    private var mProjectFragment: Fragment? = null
    private var mMineFragment: Fragment? = null
    private var mPublicFragment: Fragment? = null

    companion object {
        fun start(context: Context) {
            context.startActivity(Intent(context, HomeActivity::class.java))
        }
    }

    override fun layoutId(): Int = R.layout.home_activity_home

    override fun initView() {
        initBottomNavigation()
    }


    override fun initData() {
    }

    override fun createObserver() {
        mViewModel.getSelect().observe(this, Observer {
            switchFragment(it)
        })
    }

    /**
     * 初始化底部菜单
     */
    private fun initBottomNavigation() {
        mBottomNavigationView.apply {
            itemIconTintList = null
            setOnNavigationItemSelectedListener {
                when (it.itemId) {
                    R.id.menu_main -> saveAndSwitch(0)
                    R.id.menu_project -> saveAndSwitch(1)
                    R.id.menu_discover -> saveAndSwitch(2)
                    R.id.menu_public -> saveAndSwitch(3)
                    R.id.menu_me -> saveAndSwitch(4)
                }
                true
            }
        }
    }

    /**
     * 保存和切换选中项
     */
    private fun saveAndSwitch(index: Int) {
        mViewModel.saveSelect(index)
        switchFragment(index)
    }

    private fun switchFragment(index: Int) {
        val transaction = supportFragmentManager.beginTransaction()
        hideAllFragments(transaction)

        when(index){
            0 ->mWeatherFragment?.let {
                transaction.show(it)
            } ?:(ARouter.getInstance().build(RouterPath.Weather.PATH_WEATHER_HOME).navigation()as Fragment).let {
            mWeatherFragment = it
            transaction.add(R.id.mContentFL,it,RouterPath.Weather.PATH_WEATHER_HOME)}

            1 ->mProjectFragment?.let {
                transaction.show(it)
            }?: (ARouter.getInstance().build(RouterPath.Project.PATH_PROJECT_HOME).navigation() as Fragment).let {
                mProjectFragment = it
                transaction.add(R.id.mContentFL,it,RouterPath.Project.PATH_PROJECT_HOME)}

            2 ->mDiscoveryFragment?.let {
                transaction.show(it)
            }?: (ARouter.getInstance().build(RouterPath.Discover.PATH_DISCOVER_HOME).navigation() as Fragment).let {
                mDiscoveryFragment = it
                transaction.add(R.id.mContentFL,it,RouterPath.Discover.PATH_DISCOVER_HOME)}

            3 ->mPublicFragment?.let {
                transaction.show(it)
            }?: (ARouter.getInstance().build(RouterPath.Public.PATH_PUBLIC_HOME).navigation() as Fragment).let {
                mPublicFragment = it
                transaction.add(R.id.mContentFL,it,RouterPath.Public.PATH_PUBLIC_HOME)}

            4 ->mMineFragment?.let {
                transaction.show(it)
            }?: (ARouter.getInstance().build(RouterPath.Person.PATH_PERSON_HOME).navigation() as Fragment).let {
                mMineFragment = it
                transaction.add(R.id.mContentFL,it,RouterPath.Person.PATH_PERSON_HOME)}
        }
        transaction.commitNowAllowingStateLoss()
    }

    private fun hideAllFragments(transaction: FragmentTransaction) {
        mWeatherFragment?.let { transaction.hide(it) }
        mDiscoveryFragment?.let { transaction.hide(it)}
        mMineFragment?.let { transaction.hide(it) }
        mProjectFragment?.let { transaction.hide(it) }
        mPublicFragment?.let { transaction.hide(it) }
    }
}