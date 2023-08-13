package com.lllddd.todayfriedbreadstick.mvp.view

/**
 * author: lllddd
 * created on: 2023/6/22 22:00
 * description:Base View
 */
interface BaseView {
    fun setError(err: String)

    fun <T> setData(data : T)
}