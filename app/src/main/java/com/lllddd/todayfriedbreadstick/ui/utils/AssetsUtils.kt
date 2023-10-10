package com.lllddd.todayfriedbreadstick.ui.utils

import android.content.Context
import java.nio.charset.Charset

/**
 * author: lllddd
 * created on: 2023/9/30 10:42
 * description:Assets utils
 */
class AssetsUtils {
    companion object {
        private val CHARSET_UTF_8 = Charset.forName("UTF-8")

        /**
         * load json file form assets directory
         *
         * @param context Context
         * @param fileName fileName
         */
        fun loadJsonFromAssets(context: Context, fileName: String): String {
            return try {
                val assetManager = context.assets
                val inputStream = assetManager.open(fileName)
                val size = inputStream.available()
                val buffer = ByteArray(size)
                inputStream.read(buffer)
                inputStream.close()
                String(buffer, CHARSET_UTF_8)
            } catch (e: Exception) {
                ""
            }
        }
    }
}