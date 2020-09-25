package com.orgname.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnToast.setOnClickListener {
            Toast.makeText(
                this,
                "This is toast.",
                Toast.LENGTH_LONG).show()
        }

        btnCount.setOnClickListener {
            var count : Int = txtCount.text.toString().toInt()
            count += 1
            txtCount.text = count.toString()
        }

        btnRandom.setOnClickListener {
            var randomNum: Int = (0..100).random()
            txtCount.text = randomNum.toString()
        }

    }

    override fun onStart() {
        super.onStart()
        Log.d("ActivityLifeCycle:>>>>>","Activity Started.....")
    }

    override fun onResume() {
        super.onResume()
        Log.d("ActivityLifeCycle:>>>>>","Activity Resumed.....")
    }

    override fun onPause() {
        super.onPause()
        Log.d("ActivityLifeCycle:>>>>>","Activity Paused.....")
    }

    override fun onStop() {
        super.onStop()
        Log.d("ActivityLifeCycle:>>>>>","Activity Stopped.....")
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("ActivityLifeCycle:>>>>>","Activity Restarted.....")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("ActivityLifeCycle:>>>>>","Activity Destroyed.....")
    }
}