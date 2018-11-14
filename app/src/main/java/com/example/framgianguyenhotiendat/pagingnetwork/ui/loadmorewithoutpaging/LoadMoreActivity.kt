package com.example.framgianguyenhotiendat.pagingnetwork.ui.loadmorewithoutpaging

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.framgianguyenhotiendat.pagingnetwork.R

class LoadMoreActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_load_more)
    }

    companion object {
        fun getLoadMoreIntent(context: Context) = Intent(context,LoadMoreActivity::class.java)
    }
}
