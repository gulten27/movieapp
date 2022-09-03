package com.gultendogan.movieapp.ui.fragments.appintro

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.gultendogan.movieapp.adapter.ViewPagerAdapter
import com.gultendogan.movieapp.databinding.FragmentAppintroBinding
import com.gultendogan.movieapp.ui.fragments.appintro.pages.*
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AppIntroFragment : Fragment() {

    private var _binding : FragmentAppintroBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAppintroBinding.inflate(inflater,container,false)
        val view = binding.root

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen(),
            FourthScreen(),
            FifthScreen()
            )

        val adapter = ViewPagerAdapter(fragmentList,requireActivity().supportFragmentManager, lifecycle)

        binding.viewPager.adapter = adapter

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}