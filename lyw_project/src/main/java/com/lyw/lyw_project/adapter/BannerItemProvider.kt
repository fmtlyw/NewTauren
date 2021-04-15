package com.lyw.lyw_project.adapter

import android.app.Activity
import androidx.databinding.BindingAdapter
import androidx.lifecycle.LifecycleOwner
import com.chad.library.adapter.base.provider.BaseItemProvider
import com.chad.library.adapter.base.viewholder.BaseDataBindingHolder
import com.chad.library.adapter.base.viewholder.BaseViewHolder
import com.lyw.lyw_project.R
import com.lyw.lyw_project.databinding.ProjectItemBannerBinding
import com.lyw.lyw_project.model.ProviderMultiModel
import com.youth.banner.Banner
import com.youth.banner.indicator.CircleIndicator

/**
 * 功能描述:项目轮播图
 * Created on 2021/4/15.
 * @author lyw
 */
class BannerItemProvider(private val owner: LifecycleOwner, private val activity: Activity) :
    BaseItemProvider<ProviderMultiModel>() {
    override val itemViewType: Int = ProviderMultiModel.Type.TYPE_BANNER
    override val layoutId: Int = R.layout.project_item_banner

    override fun convert(helper: BaseViewHolder, item: ProviderMultiModel) {
        val bindingHolder = BaseDataBindingHolder<ProjectItemBannerBinding>(helper.itemView)
        bindingHolder.dataBinding?.let {
            it.activity = activity
            it.owner = owner
            it.model = item
        }
    }


    companion object {
        @JvmStatic//由于kotlin中没有静态方法，所以使用@JvmStatic来标记这个方法就是静态方法
        @BindingAdapter(value = ["data", "owner", "activity"])
        fun setBannerData(
            banner: Banner<*, *>,
            data: ProviderMultiModel,
            owner: LifecycleOwner,
            activity: Activity
        ) {
            banner.apply {
                adapter = BannerImageAdapter(banner.context, data.items)
                addBannerLifecycleObserver(owner)
                indicator = CircleIndicator(banner.context)
                setOnBannerListener { _, position ->
//                    go2VideoPlayerActivity(
//                        activity,
//                        null,
//                        data.items[position].data,
//                        true
//                    )
                }
            }
        }
    }
}