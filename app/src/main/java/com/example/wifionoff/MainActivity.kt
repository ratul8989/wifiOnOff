package com.example.wifionoff

import android.content.Context
import android.content.Intent
import android.net.wifi.WifiManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.widget.Switch
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.example.wifiOnOff.R


class MainActivity : AppCompatActivity() {
    lateinit var wifiManager: WifiManager
    lateinit var WiFiButton: Switch


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title = "KotlinApp"
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager
        WiFiButton = findViewById(R.id.switchOnOff)

        WiFiButton.setOnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked){
                startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                Toast.makeText(this, "Wifi enabled", Toast.LENGTH_SHORT).show()
            }else{
                startActivity(Intent(Settings.ACTION_WIFI_SETTINGS))
                Toast.makeText(this, "Wifi disabled", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
