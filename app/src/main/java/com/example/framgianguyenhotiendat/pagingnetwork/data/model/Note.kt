package com.example.framgianguyenhotiendat.pagingnetwork.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "note")
data class Note(
        @PrimaryKey(autoGenerate = true)
        var id : Int = 0,
        var title: String,
        var state: Boolean = false
)
