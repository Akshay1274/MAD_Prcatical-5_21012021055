package com.example.mad_prcatical_5_21012021055

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.provider.CallLog
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val buttonBrowse: Button = this.findViewById(R.id.btnBrowse)
        val editUrl : EditText = this.findViewById(R.id.EditTextUrl)

        buttonBrowse.setOnClickListener()
        {
            onBrowse(editUrl.text.toString())
        }

        val buttonCall: Button = findViewById(R.id.btnCall)
        val callNumber : EditText = findViewById(R.id.EditTextNumber )

        buttonCall.setOnClickListener()
        {
            onCall(callNumber.text.toString())
        }

        val buttonCallLog: Button = findViewById(R.id.btnCallLog)

        buttonCallLog.setOnClickListener()
        {
            onCallLog()
        }

        val buttonGallery: Button = findViewById(R.id.btnGallery)

        buttonGallery.setOnClickListener()
        {
            onGallery()
        }

        val buttonCamera: Button = findViewById(R.id.btnCamera)

        buttonCamera.setOnClickListener()
        {
            onCamera()
        }

        val buttonAlarm: Button = findViewById(R.id.btnAlarm)

        buttonAlarm.setOnClickListener()
        {
            onAlarm()
        }

    }
    private fun onBrowse(url: String)
    {
        Intent(Intent.ACTION_VIEW, Uri.parse(url)).also{startActivity(it) }
    }
    private fun onCall(number:String)
    {
        Intent(Intent.ACTION_DIAL).setData(Uri.parse("tel:$number")).also { startActivity(it) }
    }
    private fun onCallLog()
    {
        Intent(Intent.ACTION_VIEW).setType(CallLog.Calls.CONTENT_TYPE).also { startActivity(it) }
    }
    private fun onGallery()
    {
        Intent(Intent.ACTION_VIEW).setType("image/*").also { startActivity(it) }
    }
    private fun onCamera()
    {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { startActivity(it) }
    }
    private fun onAlarm()
    {
        Intent(AlarmClock.ACTION_SHOW_ALARMS).also { startActivity(it) }
    }

}
