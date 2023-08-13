package com.lllddd.todayfriedbreadstick.ui.main

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.todayfriedbreadstick.R
import com.flyco.tablayout.CommonTabLayout
import com.flyco.tablayout.listener.CustomTabEntity
import com.flyco.tablayout.listener.OnTabSelectListener
import com.lllddd.todayfriedbreadstick.base.BaseActivity
import com.lllddd.todayfriedbreadstick.ui.main.adapters.HomeAdapter
import com.lllddd.todayfriedbreadstick.ui.main.frg.HomeFragment
import com.lllddd.todayfriedbreadstick.ui.main.frg.MiniVideoFragment
import com.lllddd.todayfriedbreadstick.ui.main.frg.MyFragment
import com.lllddd.todayfriedbreadstick.ui.main.frg.VideoFragment
import com.lllddd.todayfriedbreadstick.ui.main.model.TitleModel
import com.lllddd.todayfriedbreadstick.ui.main.presenter.MainPresenter
import com.lllddd.todayfriedbreadstick.ui.main.view.MainView

class MainActivity : BaseActivity<MainView, MainPresenter>(), MainView {
    private val mTitleTabs = ArrayList<CustomTabEntity>()
    private val mFragments = ArrayList<Fragment>()

    private lateinit var mTabLayout: CommonTabLayout

    private lateinit var mViewPager: ViewPager

    override fun changeText(s: String) {

    }

    override fun setError(err: String) {
        Toast.makeText(this, err, Toast.LENGTH_LONG).show()
    }

    override fun <T> setData(data: T) {

    }

    override fun doBusiness() {

    }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initData() {
        getPresenter()?.getTest()
    }

    override fun init() {
        mFragments.add(HomeFragment())
        mFragments.add(VideoFragment())
        mFragments.add(MiniVideoFragment())
        mFragments.add(MyFragment())

        mViewPager = findViewById(R.id.vp_home)
        mViewPager.adapter = HomeAdapter(supportFragmentManager, mFragments)
        mViewPager.offscreenPageLimit = mFragments.size
        mViewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                mTabLayout.currentTab = position
            }

            override fun onPageScrollStateChanged(state: Int) {

            }
        })

        val titles = resources.getStringArray(R.array.title)

        val selectedId = resources.obtainTypedArray(R.array.selected)
        val unselectedId = resources.obtainTypedArray(R.array.unselected)

        for (i: Int in titles.indices) {
            mTitleTabs.add(
                TitleModel(
                    titles[i],
                    selectedId.getResourceId(i, 0),
                    unselectedId.getResourceId(i, 0)
                )
            )
        }

        mTabLayout = findViewById(R.id.ctl_home)
        mTabLayout.setTabData(mTitleTabs)
        mTabLayout.setOnTabSelectListener(object : OnTabSelectListener {
            override fun onTabSelect(position: Int) {
                mViewPager.setCurrentItem(position, true)
            }

            override fun onTabReselect(position: Int) {
            }
        })

        selectedId.recycle()
        unselectedId.recycle()
    }

    override fun createPresenter(): MainPresenter {
        return MainPresenter()
    }
}
