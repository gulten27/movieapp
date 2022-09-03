package com.gultendogan.movieapp.ui.fragments.appintro.pages

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.gultendogan.movieapp.R
import com.gultendogan.movieapp.databinding.FragmentFirstBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FirstScreen: Fragment() {

    private var _binding : FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater,container,false)
        val view = binding.root

        return view
    }

    override fun onResume() {
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        val prevButton = activity?.findViewById<RelativeLayout>(R.id.prevButton)
        val nextButton = activity?.findViewById<RelativeLayout>(R.id.nxtButton)

        prevButton?.alpha = 0f
        prevButton?.isClickable = false

        nextButton?.setOnClickListener {
            viewPager?.currentItem = 1
        }

        super.onResume()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}