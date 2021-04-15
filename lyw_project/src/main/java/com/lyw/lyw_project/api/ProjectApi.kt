package com.lyw.lyw_project.api

import com.lyw.lyw_provider.model.ProjectBanner
import retrofit2.http.GET

/**
 * 功能描述:
 * Created on 2021/4/15.
 * @author lyw
 */
interface ProjectApi {
    @GET("v2/feed?num=1")
    suspend fun getProjectBanner(): ProjectBanner
}