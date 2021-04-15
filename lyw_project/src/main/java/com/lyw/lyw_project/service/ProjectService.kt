package com.lyw.lyw_project.service
import com.lyw.lyw_common.http.RetrofitClient
import com.lyw.lyw_project.api.ProjectApi

/**
 * 功能描述:
 * Created on 2021/4/15.
 * @author lyw
 */
object ProjectService : ProjectApi by RetrofitClient.instances.create(ProjectApi::class.java)
