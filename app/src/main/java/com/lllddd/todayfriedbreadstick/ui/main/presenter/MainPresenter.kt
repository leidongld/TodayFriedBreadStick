package com.lllddd.todayfriedbreadstick.ui.main.presenter

import com.lllddd.todayfriedbreadstick.http.HttpUtils
import com.lllddd.todayfriedbreadstick.http.ResponseListener
import com.lllddd.todayfriedbreadstick.http.UserApi
import com.lllddd.todayfriedbreadstick.mvp.model.BaseModel
import com.lllddd.todayfriedbreadstick.mvp.presenter.BasePresenter
import com.lllddd.todayfriedbreadstick.ui.main.model.MainModel
import com.lllddd.todayfriedbreadstick.ui.main.view.MainView

/**
 * author: lllddd
 * created on: 2023/6/22 22:28
 * description:Main Presenter
 */
class MainPresenter() : BasePresenter<MainView> {
    override var mBaseView: MainView? = null

    fun getTest() {
        HttpUtils.sendHttp(
            HttpUtils.createApi(UserApi::class.java).getTest(),
            object : ResponseListener<BaseModel<MainModel>> {
                override fun onSuccess(data: BaseModel<MainModel>) {
                    getBaseView()?.setData(data)
                }

                override fun onFail(err: String) {
                    getBaseView()?.setError(err)
                }

            })
    }
}