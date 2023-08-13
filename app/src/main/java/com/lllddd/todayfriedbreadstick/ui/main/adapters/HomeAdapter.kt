package com.lllddd.todayfriedbreadstick.ui.main.adapters

import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.PagerAdapter

/**
 * author: lllddd
 * created on: 2023/8/13 21:29
 * description:Home view pager adapter
 */
class HomeAdapter(fm: FragmentManager, fragmentList: ArrayList<Fragment>) :
    FragmentPagerAdapter(fm) {
    private val mFragmentList: ArrayList<Fragment> = fragmentList

    private val mFragmentManager: FragmentManager = fm

    override fun getCount(): Int {
        return mFragmentList.size
    }

    override fun getItem(position: Int): Fragment {
        return mFragmentList[position]
    }

//    override fun instantiateItem(container: ViewGroup, position: Int): Any {
//        val instantiateItem: Fragment = super.instantiateItem(container, position) as Fragment
//        val item: Fragment = mFragmentList[position]
//        return if (instantiateItem == item) {
//            instantiateItem
//        } else {
//            //如果集合中对应下标的fragment和fragmentManager中的对应下标的fragment对象不一致，那么就是新添加的，所以自己add进入；
//            // 这里为什么不直接调用super方法呢，因为fragment的mIndex搞的鬼，以后有机会再补一补。
//            mFragmentManager.beginTransaction().add(container.id, item)
//                .commitNowAllowingStateLoss()
//            item
//        }
//    }
//
//    override fun getItemPosition(obj: Any): Int {
//        if (
//            obj is Fragment) {
//            val fragment: Fragment = obj
//            if (!fragment.isAdded || !mFragmentList.contains(obj)) {
//                return PagerAdapter.POSITION_NONE
//            }
//        }
//        return mFragmentList.indexOf(
//            obj
//        )
//    }
//
//    override fun destroyItem(container: ViewGroup, position: Int, obj: Any) {
//        val fragment: Fragment = obj as Fragment
//        //如果getItemPosition中的值为PagerAdapter.POSITION_NONE，就执行该方法。
//        if (mFragmentList.contains(fragment)) {
//            super.destroyItem(container, position, obj)
//            return
//        }
//        //自己执行移除。因为mFragments在删除的时候就把某个fragment对象移除了，所以一般都得自己移除在fragmentManager中的该对象。
//        mFragmentManager.beginTransaction().remove(fragment).commitNowAllowingStateLoss()
//    }
}