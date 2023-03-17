package com.fomichev.animechan

import androidx.lifecycle.ViewModel
import com.fomichev.animechan.repository.AnimechanRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimechanViewModel @Inject constructor(
    val animechanRepository: AnimechanRepository
) : ViewModel() {

}