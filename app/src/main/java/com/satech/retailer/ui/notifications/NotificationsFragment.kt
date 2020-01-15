package com.satech.retailer.ui.notifications

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.snackbar.Snackbar
import com.satech.retailer.R
import com.satech.retailer.data.AppSession
import com.satech.retailer.ui.other.Place
import kotlinx.android.synthetic.main.fragment_notifications.*


class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        notificationsViewModel =
            ViewModelProviders.of(this).get(NotificationsViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_notifications, container, false)
        val textView: TextView = root.findViewById(R.id.text_notifications)
        notificationsViewModel.text.observe(this, Observer {
            textView.text = it
        })
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()
    }

    private fun refresh(k:Int)
    {
        location.text = AppSession.latitude.toString()+" - "+AppSession.longitude.toString()
        Handler().postDelayed(
            {
                if (k<4)
                refresh(k+1)
            },1000
        )
    }


    private fun init()
    {
        location.text = AppSession.latitude.toString()+" - "+AppSession.longitude.toString()

        button3.setOnClickListener()
        {
            startActivity(Intent(context, Place::class.java))

//            val ft  = fragmentManager!!.beginTransaction()
//            ft.replace(R.id.nav_host_fragment, NotificationsFragment()).addToBackStack(null).commit()
//            Toast.makeText(context, AppSession.LocationCoordinates, Toast.LENGTH_LONG).show()
            //location.text = AppSession.LocationCoordinates!!.latitude.toString()+" - "+AppSession.LocationCoordinates!!.longitude.toString()

            //getFragmentManager()!!.beginTransaction().detach(this).attach(this).commit();
            refresh(1)

//            Handler().postDelayed(
//                {
//                    location.text = AppSession.latitude.toString()+" - "+AppSession.longitude.toString()
//                    Snackbar.make(view!!, AppSession.longitude.toString()+"-"+AppSession.latitude.toString(), Snackbar.LENGTH_LONG).show()
//
//                },4000
//            )
            //refresh()
        }



    }


}