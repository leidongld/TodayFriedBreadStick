package com.lllddd.todayfriedbreadstick.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lllddd.todayfriedbreadstick.mvp.presenter.BasePresenter
import com.lllddd.todayfriedbreadstick.mvp.view.BaseView

/**
 * author: lllddd
 * created on: 2023/6/22 22:03
 * description:Base Activity
 */
abstract class BaseActivity<V, P : BasePresenter<V>> : AppCompatActivity(), BaseView {
    private var mPresenter: P? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



        setContentView(getLayoutId())

        if (mPresenter == null) {
            mPresenter = createPresenter()
        }

        mPresenter!!.bindView(this as V)

        init()

        initData()

        doBusiness()
    }

    /**
     * Do business
     */
    abstract fun doBusiness()

    /**
     * Get view's layout id
     */
    abstract fun getLayoutId(): Int

    /**
     * Init data
     */
    abstract fun initData()

    /**
     * Init
     */
    abstract fun init()

    /**
     * Create presenter
     */
    abstract fun createPresenter(): P?

    /**
     * Get presenter
     */
    fun getPresenter(): P? {
        return mPresenter
    }

    override fun onDestroy() {
        super.onDestroy()

        // Unbind presenter
        mPresenter!!.unbindView()
    }
}