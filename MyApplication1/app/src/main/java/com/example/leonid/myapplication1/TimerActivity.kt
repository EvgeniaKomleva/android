package com.example.leonid.myapplication1

import android.os.Bundle
import android.os.CountDownTimer
import android.support.v7.app.AppCompatActivity
import android.util.Log
import java.util.concurrent.TimeUnit
import kotlinx.android.synthetic.main.activity_timer.*
import com.example.leonid.myapplication1.util.toText
//import com.example.leonid.myapplication1.util.toText
/*
import com.wunder9l.firsthomework.util.toText
import kotlinx.android.synthetic.main.activity_second.*
*/
class TimerActivity : AppCompatActivity() {
    var counter = 0
    var isCountDown = false
    val timer = object : CountDownTimer(TimeUnit.SECONDS.toMillis(1000), TimeUnit.SECONDS.toMillis(1)) {
        override fun onFinish() {
            start()
        }

        override fun onTick(value: Long) {
            counter++
            updateState()
        }
    }

    override fun onStop() {
        Log.d("onStop", "stop $this")
        timer.cancel()
        super.onStop()
    }

    override fun onDestroy() {
        Log.d("onDestroy", "destroy $this")
        super.onDestroy()
    }

    override fun onSaveInstanceState(outState: Bundle?) {
        outState?.putBoolean("isCountDown", isCountDown)
        outState?.putInt("counter", counter)
        super.onSaveInstanceState(outState)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_timer)
        counter = savedInstanceState?.getInt("counter") ?: 0
        isCountDown = savedInstanceState?.getBoolean("isCountDown") ?: false

        if (counter == 0) {
            restoreState()
        } else {
            updateState()
            if (isCountDown) {
                button.text = "stop"
                button.setOnClickListener { stopButtonPressed() }
                timer.start()
            } else {
//                timer.cancel()
                button.text = "start"
                button.setOnClickListener { startButtonPressed() }
            }
        }
    }

    fun restoreState() {
        textView.text = ""
        button.text = "start"
        button.setOnClickListener { startButtonPressed() }
        timer.cancel()
        counter = 0
        isCountDown = false
    }

    private fun startButtonPressed() {
        updateState()
        button.text = "stop"
        button.setOnClickListener { stopButtonPressed() }
        timer.start()
        isCountDown = true
    }

    private fun stopButtonPressed() {
        timer.cancel()
        isCountDown = false
        button.text = "start"
        button.setOnClickListener { startButtonPressed() }
    }

    private fun updateState() {
        if (counter == 1000) {
            restoreState()
            textView.text = "тысяча"
        } else {
            textView.text = toText(counter)
            Log.d("updateState", "$counter - ${textView.text}")
        }
    }

}

/*class TimerActivity {
}*/