package com.satech.retailer.ui.Register_and_Login


import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.satech.retailer.R
import com.satech.retailer.ui.Camera_Fragment
import kotlin.concurrent.thread

/**
 * A simple [Fragment] subclass.
 */
class Splash_Screen : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_splash__screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Handler().postDelayed(
            {
                val transaction = activity!!.supportFragmentManager.beginTransaction()
                var login_fragment = Login_Fragment()
                transaction.replace(R.id.splash_fragment, login_fragment)
                transaction.addToBackStack(null)
                transaction.commit()
            },2000
        )
    }


}
