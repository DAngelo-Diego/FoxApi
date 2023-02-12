package com.study.duckapi.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import com.study.duckapi.databinding.ActivityMainBinding
import com.study.duckapi.domain.extensions.load
import com.study.duckapi.domain.model.DuckModel
import com.study.duckapi.domain.util.ResourceState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val mainViewModel: MainViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initObserver()
    }

    private fun initObserver() {
        mainViewModel.duckState.observe(this) { it ->
            when(it){
                is ResourceState.Success -> it.data?.let { bindText(duckModel = it) }
                is ResourceState.Error -> bindError()
            }
        }
    }

    private fun bindError() {
        Toast.makeText(this, "Ups...try again! xd", Toast.LENGTH_SHORT).show()
    }

    private fun bindText(duckModel: DuckModel) {
        with(binding){
            tvUrl.text = duckModel.url
            ivPicture.load(url = duckModel.img)
        }
    }


}