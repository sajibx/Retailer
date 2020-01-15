package com.satech.retailer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.satech.retailer.ui.Register_and_Login.Splash_Screen

class SplashScreen : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        supportActionBar?.hide()

        val transaction = supportFragmentManager.beginTransaction()
        var splash_fragment = Splash_Screen()
        transaction.replace(R.id.splash_fragment, splash_fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}
