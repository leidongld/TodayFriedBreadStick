package com.lllddd.todayfriedbreadstick.ui.main.model

/**
 * author: lllddd
 * created on: 2023/9/27 19:26
 * description:Home fragment's data
 */
data class HomeFragDataBean(
    val banner: List<BannerBean>,
    val products: List<ProductBean>,
    val title: String
)

data class BannerBean(
    val foodPicture: String
)

data class ProductBean(
    val detail: String,
    val name: String,
    val originalPrice: String,
    val picture: String,
    val price: String,
    val score: String
)