package com.satech.retailer.ui


import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.zxing.Result

import com.satech.retailer.R
import kotlinx.android.synthetic.main.activity_main.*
import me.dm7.barcodescanner.zxing.ZXingScannerView

/**
 * A simple [Fragment] subclass.
 */
class Camera_Fragment : Fragment(), ZXingScannerView.ResultHandler {

    private var scannerView :ZXingScannerView? = null
    private val REQUEST_CAMERA = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_camera_, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        scannerView = ZXingScannerView(context)
        activity!!.setContentView(scannerView)

        if (!checkPermission())
            requestPermission()
    }

    private fun checkPermission() : Boolean
    {
        return ContextCompat.checkSelfPermission(context!!, android.Manifest.permission.CAMERA)==PackageManager.PERMISSION_GRANTED
    }

    private fun requestPermission()
    {
        ActivityCompat.requestPermissions(Activity(), arrayOf(android.Manifest.permission.CAMERA),REQUEST_CAMERA)
    }

    override fun onResume() {
        super.onResume()
        if (checkPermission())
        {
            if (scannerView == null)
            {
                scannerView = ZXingScannerView(context)
                activity!!.setContentView(scannerView)
            }
            scannerView?.setResultHandler(this)
            scannerView?.startCamera()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        scannerView!!.stopCamera()
    }

    override fun handleResult(p0: Result?) {
        val result = p0!!.text
        val builder = AlertDialog.Builder(context)
        builder.setTitle("Code")
        builder.setPositiveButton("OK")
        {
            dialogInterface, i ->
            scannerView!!.resumeCameraPreview(this)
            startActivity(Intent())
        }
        builder.setMessage(result)
        val alert = builder.create()
        alert.show()

        startActivity(Intent(context!!, Camera_Activity::class.java).putExtra("code", result))
    }


}
