package com.example.mainproject.data.db.relations

import androidx.room.*
import com.example.mainproject.data.db.entitys.CheckListPoints
import com.example.mainproject.data.model.CheckListModel


data class CheckListWithCheckListModel(
    @Embedded val CheckList: CheckListModel,
    @Relation(
        parentColumn = "checkListModelID",
        entityColumn = "checkListColumnID"
    )
    val checkListPoints: List<CheckListPoints>
)



