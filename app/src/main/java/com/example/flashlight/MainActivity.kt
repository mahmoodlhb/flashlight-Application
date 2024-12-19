package com.example.flashlight

import android.content.ContentValues.TAG
import android.hardware.camera2.CameraManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {
//********************************* this app is so easy but for learners and android developers I use KISS to easy to use!*********************************
    ///there are so many spaces here but i put them to make separate parts
    private lateinit var cameraManager: CameraManager
    private var cameraId: String? = null
    private var isFlashlightOn = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val flashlightButton: Button = findViewById(R.id.flashlightButton)
        cameraManager = getSystemService(CAMERA_SERVICE) as CameraManager
        cameraId = cameraManager.cameraIdList[0]

        flashlightButton.setOnClickListener {
            toggleFlashlight()
        }
    }
    private fun toggleFlashlight() {
        try {
            isFlashlightOn = !isFlashlightOn
            cameraManager.setTorchMode(cameraId!!, isFlashlightOn)

        }catch (e : Exception){
            Log.d(TAG, "if there is an error here is:"+e.toString())
        }
           }
}