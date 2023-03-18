package com.fomichev.animechan.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fomichev.animechan.repository.Anime
import com.fomichev.animechan.repository.AnimechanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AnimechanViewModel @Inject constructor(
    val animechanRepository: AnimechanRepository
) : ViewModel() {

    private val _animeList = MutableStateFlow<List<Anime>>(listOf())
    val animeList: StateFlow<List<Anime>> = _animeList

    init{
        getAnime()
    }

    private fun getAnime() {
        viewModelScope.launch {
            _animeList.value = animechanRepository.getAnime()
        }
    }
}