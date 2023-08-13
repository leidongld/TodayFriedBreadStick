package com.lllddd.todayfriedbreadstick.base

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 * author: lllddd
 * created on: 2023/6/23 17:38
 * description:Base App
 */
class BaseApp : Application() {
    override fun onCreate() {
        super.onCreate()

        // 初始化日志
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}