package com.mahmoudbashir.gymcompose.ui.viewModel

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class GymDetailsViewModel(
    private val savedStateHandle: SavedStateHandle
) : ViewModel(){

    init {
        val gymId = checkNotNull(savedStateHandle.get<Int>("gym_id")) // savedStateHandle.get<Int>("gym_id")?: 0
        Log.d("??????","passedGymId : $gymId")
    }


}