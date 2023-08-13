package com.lllddd.todayfriedbreadstick.ui.main.model

import com.flyco.tablayout.listener.CustomTabEntity

/**
 * author: lllddd
 * created on: 2023/8/12 20:30
 * description:Title model
 */
data class TitleModel(val title: String, val selectedImgId: Int, val unSelectedImgId: Int) :
    CustomTabEntity {
    override fun getTabTitle(): String {
        return title
    }

    override fun getTabSelectedIcon(): Int {
        return selectedImgId
    }

    override fun getTabUnselectedIcon(): Int {
        return unSelectedImgId
    }
}