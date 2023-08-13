package com.lllddd.todayfriedbreadstick.mvp.presenter

import com.lllddd.todayfriedbreadstick.base.BaseActivity

/**
 * author: lllddd
 * created on: 2023/6/22 21:51
 * description:Base Presenter
 */
interface BasePresenter<V> {
    var mBaseView: V?

    /**
     * Bind view
     *
     * @param baseView base view
     */
    fun bindView(baseView: V) {
        this.mBaseView = baseView
    }

    /**
     * Unbind view
     */
    fun unbindView() {
        this.mBaseView = null
    }

    /**
     * Obtain this instance
     */
    fun getBaseView(): V? {
        return this.mBaseView
    }
}