package com.example.framgianguyenhotiendat.pagingnetwork.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.framgianguyenhotiendat.pagingnetwork.R
import com.example.framgianguyenhotiendat.pagingnetwork.ui.apiload.ApiLoadActivity
import com.example.framgianguyenhotiendat.pagingnetwork.ui.loadmorewithoutpaging.LoadMoreActivity
import com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.RoomLoadActivity
import kotlinx.android.synthetic.main.activity_start.*

class StartActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        button_api_load.setOnClickListener { startActivity(ApiLoadActivity.getApiLoadActIntent(this)) }
        button_room_load.setOnClickListener { startActivity(RoomLoadActivity.getRoomLoadActIntent(this)) }
        button_load_more.setOnClickListener { startActivity(LoadMoreActivity.getLoadMoreIntent(this)) }
    }
}
