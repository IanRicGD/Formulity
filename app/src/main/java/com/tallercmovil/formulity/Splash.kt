package com.tallercmovil.formulity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlin.concurrent.thread

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        thread {
            Thread.sleep(5000)
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }


}