package com.satech.retailer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.bottom_dialog.*

class ItemDialog(var item:String): BottomSheetDialogFragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bottom_dialog, container, false)
    }

    override fun onClick(p0: View?) {
        when (p0?.id) {

            R.id.button -> {
                //Snackbar.make(view!!, "here", Snackbar.LENGTH_LONG).show()
                Toast.makeText(context, "here", Toast.LENGTH_SHORT).show()
            }

        }

        button.setOnClickListener()
        {
            Toast.makeText(context, "click from onClick", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        with(item){
            dialog_text.text = this
        }

        button.setOnClickListener()
        {
            Toast.makeText(context, "Click from onView", Toast.LENGTH_SHORT).show()
        }
    }
}