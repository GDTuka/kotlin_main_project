package com.example.mainproject.presentation.mainchecklistpage

import androidx.recyclerview.widget.ItemTouchHelper
import com.example.mainproject.data.db.entitys.CheckListPoints

interface UpdateCheckList {

    fun updateData(checkListPoints: CheckListPoints)
}