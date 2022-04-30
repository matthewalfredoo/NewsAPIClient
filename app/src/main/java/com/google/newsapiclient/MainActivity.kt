package com.google.newsapiclient

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.newsapiclient.data.api.NewsAPIService
import com.google.newsapiclient.databinding.ActivityMainBinding
import com.google.newsapiclient.presentation.adapter.NewsAdapter
import com.google.newsapiclient.presentation.viewmodel.NewsViewModel
import com.google.newsapiclient.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var factory: NewsViewModelFactory
    lateinit var viewModel: NewsViewModel
    @Inject
    lateinit var newsAdapter: NewsAdapter

    @Inject
    lateinit var newsApiService: NewsAPIService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bnvNews.setupWithNavController(navController)

        viewModel = ViewModelProvider(this, factory)
            .get(NewsViewModel::class.java)

        if(newsApiService == null) {
            Log.d("MyTag", "onCreate: newsApiService is null")
        }
        else {
            Log.d("MyTag", "onCreate: newsApiService is not null")
        }
    }
}