package com.lllddd.todayfriedbreadstick.ui.utils

import com.google.gson.Gson

/**
 * author: lllddd
 * created on: 2023/9/30 10:52
 * description:Gson Utils
 */
class GsonUtils {
    companion object {
        private val gson = Gson()

        /**
         * transform POJO to json string
         *
         * @param obj POJO object
         */
        fun transformToJsonString(obj: Any): String {
            return gson.toJson(obj)
        }

        /**
         * transform json string to POJO
         *
         * @param jsonStr Json string
         * @param clazz Class of T
         */
        fun <T : Any> transformToPojo(jsonStr: String, clazz: Class<T>): T {
            return gson.fromJson(jsonStr, clazz)
        }
    }
}