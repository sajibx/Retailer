package com.satech.retailer.ui.other

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.satech.retailer.MainActivity
import com.satech.retailer.R
import com.satech.retailer.data.AppSession
import com.satech.retailer.ui.notifications.NotificationsFragment
import com.sucho.placepicker.AddressData
import com.sucho.placepicker.Constants
import com.sucho.placepicker.MapType
import com.sucho.placepicker.PlacePicker
import kotlinx.android.synthetic.main.fragment_notifications.*

class Place : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_place)
        supportActionBar?.hide()



        val intent = PlacePicker.IntentBuilder()
            .setLatLong(23.7339, 90.43)  // Initial Latitude and Longitude the Map will load into
            .showLatLong(true)  // Show Coordinates in the Activity
            .setMapZoom(12.0f)  // Map Zoom Level. Default: 14.0
            .setAddressRequired(true) // Set If return only Coordinates if cannot fetch Address for the coordinates. Default: True
            .hideMarkerShadow(true) // Hides the shadow under the map marker. Default: False
            .setMarkerDrawable(R.drawable.arrow) // Change the default Marker Image
            .setMarkerImageImageColor(R.color.colorPrimary)
            .setFabColor(R.color.colorPrimary)
            .setPrimaryTextColor(R.color.colorPrimaryDark) // Change text color of Shortened Address
            .setSecondaryTextColor(R.color.colorPrimary) // Change text color of full Address
            //.setMapRawResourceStyle(R.raw.map_style)  //Set Map Style (https://mapstyle.withgoogle.com/)
            .setMapType(MapType.NORMAL)
            .onlyCoordinates(true)  //Get only Coordinates from Place Picker
            .build(this)
        startActivityForResult(intent, Constants.PLACE_PICKER_REQUEST)
    }

    override fun onActivityResult(requestCode: Int,resultCode: Int,data: Intent?) {
        if (requestCode == Constants.PLACE_PICKER_REQUEST) {
            if (resultCode == Activity.RESULT_OK) {
                val addressData = data?.getParcelableExtra<AddressData>(Constants.ADDRESS_INTENT)
                Toast.makeText(this, addressData.toString(), Toast.LENGTH_LONG).show()
                AppSession.latitude = addressData!!.latitude
                AppSession.longitude = addressData!!.longitude


                finish()
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}
