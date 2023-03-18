package com.fomichev.animechan.network

import com.fomichev.animechan.repository.Anime
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import javax.inject.Singleton


interface AnimeApiService {
    @GET("quotes")
    suspend fun getAnime10(): List<Anime>
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

@InstallIn(SingletonComponent::class)
@Module
object AnimeNetwork {

    @Provides
    @Singleton
    fun provideRetrofitService(): AnimeApiService {
        return _retrofitService ?: retrofit.create(AnimeApiService::class.java)
    }

    val API_ENDPOINT = "https://animechan.vercel.app/api/"

    private val retrofit = Retrofit.Builder()
        .baseUrl(API_ENDPOINT)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    private var _retrofitService: AnimeApiService? = null

}