package com.lllddd.todayfriedbreadstick.ui.main.frg

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.todayfriedbreadstick.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lllddd.todayfriedbreadstick.ui.main.adapters.FoodsBannerAdapter
import com.lllddd.todayfriedbreadstick.ui.main.adapters.ProductsAdapter
import com.lllddd.todayfriedbreadstick.ui.main.model.HomeFragDataBean
import com.lllddd.todayfriedbreadstick.ui.utils.AssetsUtils
import com.lllddd.todayfriedbreadstick.ui.utils.GsonUtils

/**
 * author: lllddd
 * created on: 2023/8/13 21:39
 * description:Home Fragment
 */
class HomeFragment : Fragment() {
    /**
     * Top left title
     */
    private lateinit var mTxtTitle: AppCompatTextView

    /**
     * top right search button
     */
    private lateinit var mBtnSearch: FloatingActionButton

    /**
     * Top right my button
     */
    private lateinit var mBtnMy: FloatingActionButton

    /**
     * View pager of foods items
     */
    private lateinit var mViewPagerBanner: ViewPager2

    /**
     * Foods banner adapter
     */
    private lateinit var mFoodsBannerAdapter: FoodsBannerAdapter

    /**
     * Recycler view of products
     */
    private lateinit var mRcvProducts : RecyclerView

    /**
     * Products adapter
     */
    private lateinit var mProductsAdapter : ProductsAdapter

    /**
     * The total data of home fragment
     */
    private var mHomeFragData: HomeFragDataBean? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * At this position to init test data
         */
        initData()
    }

    override fun onResume() {
        super.onResume()
        requireActivity().window.statusBarColor = resources.getColor(R.color.yellow, null)
    }

    private fun initData() {
        val dataStr = activity?.let { AssetsUtils.loadJsonFromAssets(it, "HomeFragData.json") }
        mHomeFragData = dataStr?.let { GsonUtils.transformToPojo(it, HomeFragDataBean::class.java) }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false).apply {
            initView(this)

            loadData()
        }
    }

    private fun loadData() {
        mTxtTitle.text = mHomeFragData?.title ?: "Hi，吃货！"

        mViewPagerBanner.adapter =
            activity?.let { mHomeFragData?.let { data -> FoodsBannerAdapter(it, data.banner) } }
    }

    private fun initView(view: View) {
        mTxtTitle = view.findViewById(R.id.txt_title)

        mBtnSearch = view.findViewById(R.id.btn_search)
        mBtnSearch.setOnClickListener {
            onClickSearchButton()
        }

        mBtnMy = view.findViewById(R.id.btn_my)
        mBtnMy.setOnClickListener {
            onClickMyButton()
        }

        mViewPagerBanner = view.findViewById(R.id.vp_foods)
    }

    private fun onClickMyButton() {
        // TODO:
        Toast.makeText(activity, "Click my button.", Toast.LENGTH_SHORT).show()
    }

    private fun onClickSearchButton() {
        // TODO:
        Toast.makeText(activity, "Click search button.", Toast.LENGTH_SHORT).show()
    }
}