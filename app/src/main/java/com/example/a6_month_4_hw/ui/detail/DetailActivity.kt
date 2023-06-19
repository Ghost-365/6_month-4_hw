package com.example.a6_month_4_hw.ui.detail

import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.a6_month_4_hw.core.base.BaseActivity
import com.example.a6_month_4_hw.databinding.ActivityDetailBinding

class DetailActivity : BaseActivity<ActivityDetailBinding, DetailViewModel>() {
    override fun inflateViewBinding(): ActivityDetailBinding {
        return ActivityDetailBinding.inflate(layoutInflater)
    }


    override fun initClickListener() {
        super.initClickListener()
        val intent = intent.getStringExtra("key")
        Toast.makeText(this, intent, Toast.LENGTH_SHORT).show()
    }

    override val viewModel: DetailViewModel by lazy {
        ViewModelProvider(this)[DetailViewModel::class.java]
    }

}