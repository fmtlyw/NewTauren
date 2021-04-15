package com.lyw.lyw_project.viewmodel

import androidx.lifecycle.LiveData
import com.lyw.lyw_common.base.viewmodel.BaseViewModel
import com.lyw.lyw_project.model.ProviderMultiModel
import com.lyw.lyw_project.service.ProjectService


/**
 * 功能描述:
 * Created on 2021/4/14.
 * @author lyw
 */
class CategoryViewModel : BaseViewModel() {
    private var mNextPageUrl: String? = null
    private val BANNER_TYPE = "banner2"

    fun getBanner(): LiveData<ProviderMultiModel> = liveDataEx {

        val bannerModel = ProjectService.getProjectBanner()
        mNextPageUrl = bannerModel.nextPageUrl
        val itemList = bannerModel.issueList[0].itemList
        itemList.removeAll {
            it.type == BANNER_TYPE
        }
        val providerMultiModel =
            ProviderMultiModel(type = ProviderMultiModel.Type.TYPE_BANNER, items = itemList)
        providerMultiModel
    }
}