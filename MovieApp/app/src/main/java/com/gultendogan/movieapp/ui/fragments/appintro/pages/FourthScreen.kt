package com.gultendogan.movieapp.ui.fragments.appintro.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.gultendogan.movieapp.R
import com.gultendogan.movieapp.databinding.FragmentFourthBinding

class FourthScreen: Fragment() {

    private var _binding : FragmentFourthBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFourthBinding.inflate(inflater,container,false)
        val view = binding.root

        return view
    }

    override fun onResume() {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        val prevButton = activity?.findViewById<RelativeLayout>(R.id.prevButton)
        val nextButton = activity?.findViewById<RelativeLayout>(R.id.nxtButton)

        nextButton?.alpha=1f
        nextButton?.isClickable = true

        prevButton?.setOnClickListener {
            viewPager?.currentItem = 2
        }

        nextButton?.setOnClickListener {
            viewPager?.currentItem = 4
        }

        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}