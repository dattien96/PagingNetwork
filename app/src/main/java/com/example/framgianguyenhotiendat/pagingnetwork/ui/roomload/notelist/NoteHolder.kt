package com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.notelist

import android.support.v7.widget.RecyclerView
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import com.example.framgianguyenhotiendat.pagingnetwork.databinding.ItemNoteBinding

class NoteHolder constructor(val binding: ItemNoteBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bindView(item: Note?) {
        binding.run {
            note = item ?: Note(title = "default title")
            executePendingBindings()
        }
    }
}