package com.example.mainproject.data.db.entitys

import androidx.room.*
import com.example.mainproject.data.model.CheckListModel
import java.io.Serializable

@Entity(
    tableName = "check_list_point",
    foreignKeys = [
        ForeignKey(entity = CheckListModel::class, parentColumns = ["checkListModelID"],childColumns = ["checkListColumnID"],onDelete = ForeignKey.CASCADE)
    ],
    indices = [Index("checkListColumnID")]
)
data class CheckListPoints(
    @ColumnInfo(name = "correctly")
    var correctly: Boolean,
    @ColumnInfo(name = "requirement")
    var requirement: String,
    @ColumnInfo(name = "passed")
    var passed: Boolean,
    @ColumnInfo(name="checkListColumnID")
    val checkListColumnID: Long,
    @PrimaryKey(autoGenerate = true)
    val checkListPointsModelID: Long = 0L
): Serializable