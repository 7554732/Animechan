package com.fomichev.animechan.repository

import com.fomichev.animechan.network.AnimeApiService
import javax.inject.Inject

class AnimechanRepository @Inject constructor(private val retrofitService: AnimeApiService){
    suspend fun getAnime(): List<Anime>{
        val result = retrofitService.getAnime10()
        return result
    }
}