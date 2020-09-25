package com.orgname.myfirstapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.orgname.myfirstapp.viewmodel.CountViewModel
import kotlinx.android.synthetic.main.activity_viewmodel.*

class ViewmodelActivity : AppCompatActivity() {

    val sharedFile = "SHARED_PREFERENCE"
    var sharedPreferences: SharedPreferences? = null
    var editor: SharedPreferences.Editor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_viewmodel)

        var countViewModel = ViewModelProvider(this)
            .get(CountViewModel::class.java)

       sharedPreferences = this.getSharedPreferences(sharedFile,
       Context.MODE_PRIVATE)

        editor = sharedPreferences?.edit()

        var storeCount = sharedPreferences?.getInt("COUNT", 0)

        txtVMCount.text = storeCount.toString()

       // txtVMCount.text = countViewModel.getCount().toString()

        btnVMCount.setOnClickListener {
            var count = txtVMCount.text.toString().toInt()

            countViewModel.setCount(count)

            txtVMCount.text = countViewModel.getCount().toString()



        }

    }

    override fun onPause() {
        super.onPause()
        editor?.putInt("COUNT", txtVMCount.text.toString().toInt())
        editor?.apply()
    }
}