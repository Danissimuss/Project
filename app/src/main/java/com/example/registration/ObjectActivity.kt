package com.example.registration

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import com.razorpay.Checkout
import org.json.JSONObject

class ObjectActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_object)



        Checkout.preload(applicationContext)
        val co = Checkout()

        co.setKeyID("rzp_test_KMDIOxrrKu0Lik")

        val title: TextView = findViewById(R.id.list_title)
        val text: TextView = findViewById(R.id.list_text)
        val btn:Button = findViewById(R.id.Button_buy)

        title.text = intent.getStringExtra("itemTitle")
        text.text = intent.getStringExtra("itemText")
        btn.setOnClickListener {
            startPayment()
        }
    }
    private fun startPayment() {

        val activity: Activity = this
        val co = Checkout()

        try {
            val options = JSONObject()
            options.put("name","Danisimus")
            options.put("description","Demoing Charges")
            //You can omit the image option to fetch the image from the dashboard
            options.put("image","https://s3.amazonaws.com/rzp-mobile/images/rzp.jpg")
            options.put("theme.color", "#f00");
            options.put("currency","USD");
            options.put("order_id", "order_MO7G1VqMXqn24k");
            options.put("amount", 10000)

            co.open(activity,options)
        }catch (e: Exception){
            Toast.makeText(activity,"Error in payment: "+ e.message,Toast.LENGTH_LONG).show()
            e.printStackTrace()
        }
    }
}