package com.lyw.lyw_home.splash

import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.ScaleAnimation
import com.gyf.immersionbar.ImmersionBar
import com.lyw.lyw_common.base.activity.BaseVmDbActivity
import com.lyw.lyw_home.R
import com.lyw.lyw_home.databinding.HomeActivitySplashBinding
import com.lyw.lyw_home.home.HomeActivity
import kotlinx.android.synthetic.main.home_activity_splash.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 功能描述:闪屏页
 * Created on 2021/4/13.
 * @author lyw
 */
class SplashActivity : BaseVmDbActivity<SplashViewModel, HomeActivitySplashBinding>() {

    private val job by lazy { Job() }


    private val splashDuration = 8 * 1000L

    private val alphaAnimation by lazy {
        AlphaAnimation(0.5f, 1.0f).apply {
            duration = splashDuration
            fillAfter = true//因为有动画链的原因
        }
    }

    private val scaleAnimation by lazy {
        ScaleAnimation(
            1f, 1.25f, 1f, 1.25f,
            Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f
        ).apply {
            duration = splashDuration
            fillAfter = true
        }
    }

    override fun layoutId(): Int = R.layout.home_activity_splash

    override fun initView() {
        //设置状态栏导航栏透明
        // TODO("设置无效")
//        setStatusBarBackground(R.color.colorPrimary)

        ivSlogan.startAnimation(alphaAnimation)
        ivSplashPicture.startAnimation(scaleAnimation)
        CoroutineScope(job).launch {
            delay(splashDuration)
            HomeActivity.start(this@SplashActivity)
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        job.cancel()
    }

    override fun createObserver() {
        mDataBind.model = mViewModel
        mViewModel.splashNameCn.set(getString(R.string.home_slogan_two_cn))
        mViewModel.splashNameEn.set(getString(R.string.home_slogan_two_en))
    }

    override fun initData() {
    }
}