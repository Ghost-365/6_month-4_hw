package com.example.a6_month_4_hw.ui.playlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.a6_month_4_hw.BuildConfig
import com.example.a6_month_4_hw.model.Playlist
import com.example.a6_month_4_hw.remote.ApiService
import com.example.a6_month_4_hw.remote.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PlaylistViewModel : ViewModel() {

    private val apiService: ApiService = RetrofitClient.create()

    fun getPlaylists(): LiveData<Playlist> {
        return playlists()
    }

    private fun playlists(): LiveData<Playlist> {
        val data = MutableLiveData<Playlist>()
        apiService.getPlaylists(
            "snippet,contentDetails",
            "UCWOA1ZGywLbqmigxE4Qlvuw",
            BuildConfig.API_KEY,
        ).enqueue(object : Callback<Playlist> {
            override fun onResponse(call: Call<Playlist>, response: Response<Playlist>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<Playlist>, t: Throwable) {
                print(t.stackTrace)
            }

        })

        return data
    }
}