package com.example.a6_month_4_hw.ui.playlist

import android.content.Intent
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.a6_month_4_hw.core.base.BaseActivity
import com.example.a6_month_4_hw.core.ext.CheckConnection
import com.example.a6_month_4_hw.databinding.ActivityPlaylistBinding
import com.example.a6_month_4_hw.model.Item
import com.example.a6_month_4_hw.ui.detail.DetailActivity
import com.example.a6_month_4_hw.ui.playlist.adapter.PlaylistAdapter

class PlaylistActivity : BaseActivity<ActivityPlaylistBinding, PlaylistViewModel>() {

    override val viewModel: PlaylistViewModel by lazy {
        ViewModelProvider(this)[PlaylistViewModel::class.java]
    }


    override fun checkInternet() {
        super.checkInternet()
        CheckConnection(application).observe(this) { isConnection ->
            if (isConnection) {
                binding.noInternetConnection.visibility = View.GONE
                binding.internetConnection.visibility = View.VISIBLE
            } else {
                binding.noInternetConnection.visibility = View.VISIBLE
                binding.internetConnection.visibility = View.GONE
            }
        }
    }

    private var adapter = PlaylistAdapter(this::onClick)

    override fun setupLiveData() {
        super.setupLiveData()
        viewModel.getPlaylists().observe(this) {
            binding.recyclerView.adapter = adapter

            adapter.setList(it.items)
            Toast.makeText(this, it.kind.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    override fun inflateViewBinding(): ActivityPlaylistBinding {
        return ActivityPlaylistBinding.inflate(layoutInflater)
    }

    private fun onClick(item: Item){
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("key", item.snippet.title)
        Toast.makeText(this, item.id, Toast.LENGTH_SHORT).show()
        startActivity(intent)
    }
}


