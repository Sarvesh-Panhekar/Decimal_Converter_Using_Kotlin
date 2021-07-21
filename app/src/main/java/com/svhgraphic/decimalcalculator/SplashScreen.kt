package com.svhgraphic.decimalcalculator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView


@Suppress("DEPRECATION")
class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val backgroundImage:ImageView = findViewById(R.id.logo_icon)
        val appName:TextView = findViewById(R.id.appName)

        val sideAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_up)
        backgroundImage.startAnimation(sideAnimation)
        val sideAnimationText = AnimationUtils.loadAnimation(this, R.anim.bottom_up)
        appName.startAnimation(sideAnimationText)


        Handler().postDelayed({
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }, 2000) // delaying for 4 seconds...



    }
}