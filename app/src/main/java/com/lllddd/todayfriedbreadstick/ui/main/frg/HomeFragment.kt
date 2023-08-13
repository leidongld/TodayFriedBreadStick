package com.lllddd.todayfriedbreadstick.ui.main.frg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todayfriedbreadstick.R

/**
 * author: lllddd
 * created on: 2023/8/13 21:39
 * description:
 */
class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }
}