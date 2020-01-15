package com.satech.retailer.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.github.kittinunf.fuel.httpGet
import com.github.kittinunf.result.Result
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.satech.retailer.ItemDialog
import com.satech.retailer.MainActivity
import com.satech.retailer.R
import com.satech.retailer.ui.BaseFragment
import kotlinx.android.synthetic.main.bottom_sheet.*
import kotlinx.android.synthetic.main.bottom_sheet.view.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)
//        val root = inflater.inflate(R.layout.fragment_home, container, false)
//        val textView: TextView = root.findViewById(R.id.text_home)
//        homeViewModel.text.observe(this, Observer {
//            textView.text = it
//        })
        return inflater.inflate(R.layout.fragment_home, container, false)//root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //Toast.makeText(context, "here", Toast.LENGTH_SHORT).show()
        //getView()?.let { Snackbar.make(it," ", Snackbar.LENGTH_LONG).show() }

        init()
    }

    private fun init()
    {
        button2.setOnClickListener()
        {
//            var dialog = BottomSheetDialog(context!!)
//            var view = layoutInflater.inflate(R.layout.bottom_sheet,null)
//            dialog.setContentView(view)
//            dialog.show()

            var item = "name"
            var dialog = ItemDialog(item)
            fragmentManager?.let {
                dialog.show(it, " ")
            }

//            launch {
                "https://jsonplaceholder.typicode.com/todos/1"
                    .httpGet()
                    .responseString { request, response, result ->
                        when(result)
                        {
                            is com.github.kittinunf.result.Result.Failure -> {
                                val ex = result.getException()
                                //updateUI {
                                    Toast.makeText(context, ex.toString(), Toast.LENGTH_SHORT).show()
                                //}
                            }
                            is Result.Success -> {
                                val data = result.get()
                                //updateUI {
                                    Toast.makeText(context, data, Toast.LENGTH_SHORT).show()
                                //}
                            }
                        }
                    }
            //}

        }
    }
}