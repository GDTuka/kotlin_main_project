package com.example.mainproject.data.model

import androidx.room.*
import com.example.mainproject.data.db.entitys.CheckListPoints
import java.io.Serializable

@Entity(tableName = "check_list_model")
data class CheckListModel (
    @ColumnInfo(name = "check_list_name")
    val checkListName: String,
    @ColumnInfo(name = "check_list_count")
    val checkListCount: Int,
    @ColumnInfo(name = "check_list_result")
    val checkListResult: Int,
    @ColumnInfo(name = "description")
    val description: String,
    @PrimaryKey(autoGenerate = true)
    val checkListModelID: Long = 0L
        ) : Serializable