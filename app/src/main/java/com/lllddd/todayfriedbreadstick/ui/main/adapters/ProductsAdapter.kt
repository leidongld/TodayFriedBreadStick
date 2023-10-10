package com.lllddd.todayfriedbreadstick.ui.main.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.todayfriedbreadstick.R
import com.lllddd.todayfriedbreadstick.ui.main.model.ProductBean

class ProductsAdapter(context: Context, productList: List<ProductBean>) :
    RecyclerView.Adapter<ProductsAdapter.ViewHolder>() {

    private val mContext = context

    private val mProductList = productList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductsAdapter.ViewHolder {
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_home_product, parent, false)
        return ProductsAdapter.ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductsAdapter.ViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    }
}
