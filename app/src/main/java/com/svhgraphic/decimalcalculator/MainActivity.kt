package com.svhgraphic.decimalcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds

class MainActivity : AppCompatActivity() {

    private var input: EditText? = null
    private var submit: Button? = null
    private var reset: Button? = null

    lateinit var mAdView : AdView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)


        // Calling the EditText by id which we gave in xml file
        input = findViewById<View>(R.id.editText) as EditText
        val output = findViewById<TextView>(R.id.output)
        val output2 = findViewById<TextView>(R.id.output2)
        val output3 = findViewById<TextView>(R.id.output3)
        submit = findViewById<View>(R.id.submit) as Button

        // It is set so that when the user clicks
        // on submit button, the data
        // gets send in the function created below
        // which will convert it and then
        // show the answer to the user in the output
        submit!!.setOnClickListener { // Creating a string method argument
            val string = input!!.text.toString()

            // Here, we are parsing a string method
            // argument into an integer object
            val i = string.toInt()
            // Converts and stores it in the form of string
            val binary = Integer.toBinaryString(i)

            // It will show the output in the
            // second edit text that we created
            output!!.text = binary


            // Converts and stores it in the form of string
            val hexadecimal = Integer.toHexString(i)

            // It will show the output in the
            // second edit text that we created
            output3!!.text = hexadecimal

            // Converts and stores it in the form of string
            val octal = Integer.toOctalString(i)

            // It will show the output in the
            // second edit text that we created
            output2!!.text = octal
        }

        // Refresh Button
        reset = findViewById<View>(R.id.reset) as Button
        reset!!.setOnClickListener {
            input!!.setText("")
            output!!.text = ""
            output2!!.text = ""
            output3!!.text = ""
        }
    }
}