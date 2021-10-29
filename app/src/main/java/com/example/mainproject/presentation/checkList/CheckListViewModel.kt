package com.example.mainproject.presentation.checkList

import androidx.lifecycle.ViewModel
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.data.model.CheckListPoints
import com.example.mainproject.domain.AdapterCallBack

class CheckListViewModel: ViewModel() {

    val point1 = CheckListPoints(false,"somereq",false)

    var checkListPoints = listOf<CheckListPoints>(point1)

    val checkList1 = CheckListModel("Door",checkListPoints.size,checkListPoints,0,"1234567890123456789012345")


    fun addCheckList():CheckListModel{
        return checkList1
    }



}