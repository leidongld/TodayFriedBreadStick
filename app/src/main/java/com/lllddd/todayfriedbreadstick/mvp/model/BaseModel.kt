package com.lllddd.todayfriedbreadstick.mvp.model

/**
 * author: lllddd
 * created on: 2023/6/22 21:52
 * description:Base Model
 */
data class BaseModel<T>(val code: Int, val msg: String, val data: T) {
}