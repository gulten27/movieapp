package com.gultendogan.movieapp.ui.fragments.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gultendogan.movieapp.R
import com.gultendogan.movieapp.databinding.FragmentMainBinding
import com.gultendogan.movieapp.prefs.SessionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root

        if (sessionManager.getFirstRun()){
            sessionManager.setIsFirstRun(false)
        }

        setupTabBar()

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupTabBar(){
        binding.bottomNavBar.setItemSelected(R.id.nav_home,true)
        binding.bottomNavBar.setOnItemSelectedListener {
            when(it){
                R.id.nav_home -> childFragmentManager.
                primaryNavigationFragment?.
                findNavController()?.
                navigate(R.id.homeFragment)

                R.id.nav_favorites -> childFragmentManager.
                primaryNavigationFragment?.
                findNavController()?.
                navigate(R.id.favoriteFragment)

                R.id.nav_settings -> childFragmentManager.
                primaryNavigationFragment?.
                findNavController()?.
                navigate(R.id.settingsFragment2)
            }
        }
    }
}