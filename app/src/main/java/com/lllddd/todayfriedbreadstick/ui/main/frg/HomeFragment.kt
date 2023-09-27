package com.lllddd.todayfriedbreadstick.ui.main.frg

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatTextView
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.todayfriedbreadstick.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.lllddd.todayfriedbreadstick.ui.main.adapters.FoodsBannerAdapter

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

    private lateinit var mFoodsBannerAdapter : FoodsBannerAdapter

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        val paramStr = arguments?.getString("param")
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