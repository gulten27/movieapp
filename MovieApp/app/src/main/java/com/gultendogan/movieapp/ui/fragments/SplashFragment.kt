package com.gultendogan.movieapp.ui.fragments

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gultendogan.movieapp.R
import com.gultendogan.movieapp.databinding.FragmentSplashBinding
import com.gultendogan.movieapp.prefs.SessionManager
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SplashFragment: Fragment() {

    private var _binding : FragmentSplashBinding? = null
    private val binding get() = _binding!!

    @Inject
    lateinit var sessionManager: SessionManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(inflater,container,false)
        val view = binding.root

        Handler(Looper.getMainLooper()).postDelayed({
            //findNavController().navigate((R.id.action_splashFragment_to_mainFragment))

            if(sessionManager.getFirstRun()){
                //findNavController().navigate((R.id.action_splashFragment_to_appIntroFragment))
                findNavController().navigate((R.id.action_splashFragment_to_mainFragment))
            }else{
                findNavController().navigate((R.id.action_splashFragment_to_mainFragment))
            }
        },3000)

        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}