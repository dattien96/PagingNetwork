package com.example.framgianguyenhotiendat.pagingnetwork.ui.apiload

import android.arch.lifecycle.*
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.framgianguyenhotiendat.pagingnetwork.R
import com.example.framgianguyenhotiendat.pagingnetwork.data.model.Article
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.api.FeedApi
import com.example.framgianguyenhotiendat.pagingnetwork.data.source.remote.pagesource.FeedRemotePagedFactory
import com.example.framgianguyenhotiendat.pagingnetwork.databinding.ActivityMainBinding
import com.example.framgianguyenhotiendat.pagingnetwork.ui.ViewModelProviderFactory
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class ApiLoadActivity : AppCompatActivity(), LifecycleOwner {

    @Inject
    lateinit var viewModelFactory: ViewModelProviderFactory

    private lateinit var viewModel: ApiLoadViewModel
    private lateinit var binding: ActivityMainBinding
    private lateinit var articleAdapter: FeedAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.setLifecycleOwner(this)

        initAdapter()
        initViewModel()
        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.articles.observe(this, Observer {
            articleAdapter.submitList(it)
        })
    }

    private fun initAdapter() {
        articleAdapter = FeedAdapter()
        recycler_article.adapter = articleAdapter
    }

    private fun initViewModel() {
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(ApiLoadViewModel::class.java)
        lifecycle.addObserver(viewModel)

    }

    companion object {
        fun getApiLoadActIntent(context: Context) = Intent(context, ApiLoadActivity::class.java)
    }
}
