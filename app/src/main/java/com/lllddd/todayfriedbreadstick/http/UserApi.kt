package com.lllddd.todayfriedbreadstick.http

import com.lllddd.todayfriedbreadstick.mvp.model.BaseModel
import com.lllddd.todayfriedbreadstick.ui.main.model.MainModel
import io.reactivex.Observable
import retrofit2.http.GET

/**
 * author: lllddd
 * created on: 2023/8/5 11:21
 * description:User API
 */
interface UserApi {
    @GET(value = "index?type=top&key=2c1cb93f8c7430a754bc3ad62e0fac06")
    fun getTest(): Observable<BaseModel<MainModel>>
}