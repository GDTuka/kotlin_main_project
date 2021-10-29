package com.example.mainproject.presentation.addchecklistpage

import androidx.lifecycle.ViewModel
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.data.model.CheckListPoints

class AddCheckListVM: ViewModel() {

    val point1 = CheckListPoints(false,"somereq",false)

    var checkListPoints = listOf<CheckListPoints>(point1)

    val door = CheckListModel("Door",checkListPoints.size,checkListPoints,0,"1234567890123456789012345")
    val window = CheckListModel("Window",checkListPoints.size,checkListPoints,0,"1234567890123456789012345")
}