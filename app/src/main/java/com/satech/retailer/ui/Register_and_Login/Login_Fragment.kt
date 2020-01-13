package com.satech.retailer.ui.Register_and_Login


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.satech.retailer.MainActivity

import com.satech.retailer.R
import com.satech.retailer.ui.Camera_Activity
import kotlinx.android.synthetic.main.fragment_login_.*

/**
 * A simple [Fragment] subclass.
 */
class Login_Fragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login.setOnClickListener()
        {
            //startActivity(Intent(context, MainActivity::class.java))
            //activity!!.finish()

            startActivity(Intent(context, Camera_Activity::class.java))
            activity!!.finish()
        }
    }


}
