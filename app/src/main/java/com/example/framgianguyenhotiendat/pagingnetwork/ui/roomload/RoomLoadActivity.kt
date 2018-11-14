package com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.framgianguyenhotiendat.pagingnetwork.R
import com.example.framgianguyenhotiendat.pagingnetwork.ui.ViewModelProviderFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_room_load.*
import javax.inject.Inject
import android.support.design.widget.Snackbar
import com.example.framgianguyenhotiendat.pagingnetwork.R.id.*
import com.example.framgianguyenhotiendat.pagingnetwork.databinding.ActivityRoomLoadBinding
import com.example.framgianguyenhotiendat.pagingnetwork.ui.roomload.notelist.NotesFragment
import dagger.android.support.DaggerAppCompatActivity


class RoomLoadActivity : DaggerAppCompatActivity(), LifecycleOwner, RoomLoadNavigator {

    private lateinit var viewModel: RoomLoadViewModel
    private lateinit var binding: ActivityRoomLoadBinding

    override fun addNoteItem() {
        edit_title.text.clear()
        edit_des.text.clear()
        linear_content.showSnackBar("Note added", Snackbar.LENGTH_SHORT)
    }

    override fun goToNoteList() {
        supportFragmentManager.beginTransaction()
                .replace(R.id.linear_content,NotesFragment.getNotesFragment())
                .addToBackStack(null)
                .commit()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_room_load)
        binding.setLifecycleOwner(this)
        initViewModel()
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory)
                .get(RoomLoadViewModel::class.java).apply {
                    navigator = this@RoomLoadActivity
                    binding.viewModel = this
                }
    }

    companion object {
        fun getRoomLoadActIntent(context: Context) = Intent(context, RoomLoadActivity::class.java)
    }

    private fun View.showSnackBar(message: String, duration: Int) {
        Snackbar.make(this, message, duration).show()
    }
}
