package com.satech.retailer.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import com.google.zxing.Result
import com.satech.retailer.R
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.jetbrains.anko.contentView

class Camera_Activity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera_)

        var name = intent.getStringExtra("code")

        Snackbar.make(contentView!!, name.toString(), Snackbar.LENGTH_LONG).show()

    }
}
