package com.lllddd.todayfriedbreadstick.http

/**
 * author: lllddd
 * created on: 2023/8/5 11:06
 * description:Http response listener
 */
interface ResponseListener<T> {
    /**
     * Success
     *
     * @param data Success data
     */
    fun onSuccess(data: T)

    /**
     * Fail
     *
     * @param err Error message
     */
    fun onFail(err: String)
}