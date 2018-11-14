package com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.notelist

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Note
import com.example.framgianguyenhotiendat.pagingnetwork.databinding.ItemNoteBinding

class NotesAdapter : PagedListAdapter<Note, NoteHolder>(NOTE_DIFF) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NoteHolder(ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false))


    override fun onBindViewHolder(holder: NoteHolder, position: Int) {
        holder.bindView(getItem(position))
    }

    companion object {
        private val NOTE_DIFF = object : DiffUtil.ItemCallback<Note>() {
            override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem == newItem
            }

            override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
                return oldItem.id == newItem.id
            }

        }
    }
}