package com.example.mainproject.data.db.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.example.mainproject.data.db.entitys.CheckListPoints
import com.example.mainproject.data.model.CheckListModel

data class CheckListWithCheckListModel(
    @Embedded val CheckList: CheckListModel,
    @Relation(
        parentColumn = "checkListModelID",
        entityColumn = "checkListPointsModelID"
    )
    val checkListPoints: List<CheckListPoints>
)