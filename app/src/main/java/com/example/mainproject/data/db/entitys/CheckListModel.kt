package com.example.mainproject.data.model

import androidx.room.*
import com.example.mainproject.data.db.entitys.CheckListPoints
import java.io.Serializable

@Entity(tableName = "check_list_model")
data class CheckListModel (
    @ColumnInfo(name = "check_list_name")
    var checkListName: String,
    @ColumnInfo(name = "check_list_count")
    var checkListCount: Int,
    @ColumnInfo(name = "check_list_result")
    var checkListResult: Int,
    @ColumnInfo(name = "description")
    var description: String,
    @PrimaryKey(autoGenerate = true)
    var checkListModelID: Long = 0L
        ) : Serializable