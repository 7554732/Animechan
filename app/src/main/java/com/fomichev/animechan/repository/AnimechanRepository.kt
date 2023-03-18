package com.fomichev.animechan.repository

import com.fomichev.animechan.network.AnimeApiService
import kotlinx.coroutines.flow.MutableStateFlow
import javax.inject.Inject

class AnimechanRepository @Inject constructor(private val retrofitService: AnimeApiService){
    suspend fun getAnime(): List<Anime>{
        val result = retrofitService.getAnime10()
//        val result = listOf(
//            Anime("1"),
//            Anime("2"),
//            Anime("3"),
//        )


        return result
    }
}