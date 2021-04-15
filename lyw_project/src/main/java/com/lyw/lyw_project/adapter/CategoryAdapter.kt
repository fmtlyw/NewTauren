package com.lyw.lyw_project.adapter
import android.app.Activity
import androidx.lifecycle.LifecycleOwner
import com.chad.library.adapter.base.BaseProviderMultiAdapter
import com.chad.library.adapter.base.module.LoadMoreModule
import com.lyw.lyw_project.model.ProviderMultiModel

/**
 * 功能描述:关注适配器
 * Created on 2021/4/14.
 * @author lyw
 */
class CategoryAdapter(activity: Activity,owner:LifecycleOwner) :BaseProviderMultiAdapter<ProviderMultiModel>(),LoadMoreModule{

    init {
        addItemProvider(BannerItemProvider(owner,activity))
    }

    override fun getItemType(data: List<ProviderMultiModel>, position: Int): Int =
        data[position].type
}