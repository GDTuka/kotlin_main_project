package com.example.mainproject.data.db.entitys

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "check_list_point")
data class CheckListPoints(
    @ColumnInfo(name = "correctly")
    var correctly: Boolean,
    @ColumnInfo(name = "requirement")
    var requirement: String,
    @ColumnInfo(name = "passed")
    var passed: Boolean,
    @PrimaryKey(autoGenerate = true)
    val checkListPointsModelID: Long = 0L
): Serializable