package com.lllddd.todayfriedbreadstick.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.todayfriedbreadstick.R
import com.lllddd.todayfriedbreadstick.ui.main.model.BannerBean

class FoodsBannerAdapter(context: Context, banners: List<BannerBean>) :
    RecyclerView.Adapter<FoodsBannerAdapter.ViewHolder>() {

    private var mContext: Context = context
    private var mBanners: List<BannerBean> = banners

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): FoodsBannerAdapter.ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_food_banner, parent, false)
        return FoodsBannerAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: FoodsBannerAdapter.ViewHolder, position: Int) {
        if (itemCount == 0) {
            return
        }

        Glide.with(mContext).load(mBanners[position]).into(holder.mImgFood)
    }

    override fun getItemCount(): Int {
        return mBanners.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val mImgFood: AppCompatImageView = itemView.findViewById(R.id.img_food)
    }
}
