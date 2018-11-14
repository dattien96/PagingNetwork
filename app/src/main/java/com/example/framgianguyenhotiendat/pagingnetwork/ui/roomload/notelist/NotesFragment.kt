package com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.notelist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.framgianguyenhotiendat.pagingnetwork.databinding.FragmentNotesBinding
import com.example.framgianguyenhotiendat.pagingnetwork.ui.ViewModelProviderFactory
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

class NotesFragment : Fragment() {

    lateinit var binding: FragmentNotesBinding
    lateinit var viewModel: NotesViewModel
    lateinit var notesAdapter: NotesAdapter

    @Inject
    lateinit var viewModelProviderFactory: ViewModelProviderFactory

    override fun onAttach(context: Context?) {
        performDependencyInjection()
        super.onAttach(context)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        notesAdapter = NotesAdapter()
        binding.apply {
            setLifecycleOwner(this@NotesFragment)
            recyclerNote.adapter = notesAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelProviderFactory)
                .get(NotesViewModel::class.java)
        lifecycle.addObserver(viewModel)

        viewModel.notes.observe(this, Observer {
            notesAdapter.submitList(it)
        })

    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }

    companion object {
        fun getNotesFragment() = NotesFragment()
    }
}