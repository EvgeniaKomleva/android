package com.example.leonid.myapplication1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.content.Intent
import android.util.Log
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {
    val timer = object : CountDownTimer(TimeUnit.SECONDS.toMillis(2), TimeUnit.SECONDS.toMillis(1)) {
        override fun onFinish() {
            val intent = Intent(this@MainActivity, TimerActivity::class.java)
            startActivity(intent)
            Log.d("MainActivity", "Started second activity")
            finish()
        }

        override fun onTick(value: Long) {}
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        timer.start()
        super.onResume()
    }

    override fun onStop() {
        timer.cancel()
        super.onStop()
    }
}