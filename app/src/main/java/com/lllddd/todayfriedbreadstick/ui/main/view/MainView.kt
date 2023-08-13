package com.lllddd.todayfriedbreadstick.ui.main.view

import com.lllddd.todayfriedbreadstick.mvp.view.BaseView

/**
 * author: lllddd
 * created on: 2023/6/22 22:29
 * description:Main view
 */
interface MainView : BaseView {
    fun changeText(s: String)
}