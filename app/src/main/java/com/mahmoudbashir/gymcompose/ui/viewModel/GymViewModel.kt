package com.mahmoudbashir.gymcompose.ui.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.mahmoudbashir.gymcompose.ui.model.gList

class GymViewModel(
    private val stateHandle: SavedStateHandle // used to save/restores data
):ViewModel() {
    var state by mutableStateOf(getGyms())


   private fun getGyms() = gList

    fun toggleFavourite(gymId:Int){
        val mlist = state.toMutableList()
        val itemIndex = mlist.indexOfFirst { it.id == gymId }
        mlist[itemIndex] = mlist[itemIndex].copy(isFavourite = !mlist[itemIndex].isFavourite)
        state = mlist
    }
}