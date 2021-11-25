package com.example.mainproject.presentation.mainchecklistpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainproject.data.db.entitys.CheckListPoints
import com.example.mainproject.domain.dbdata.CheckListModelDBDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainCheckListPageVM(private val database: CheckListModelDBDao): ViewModel() {

    fun update(data:CheckListPoints){
        viewModelScope.launch(Dispatchers.IO) {
            updateData(data)
        }
    }

    private fun updateData(checkListPoints: CheckListPoints){
        database.updateCorrectly(checkListPoints)
    }
}