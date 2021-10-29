package com.example.mainproject.data.model

import java.io.Serializable

data class CheckListModel (
    val checkListName: String,
    val checkListCount: Int,
    val checkListPoints: List<CheckListPoints>,
    val checkListResult: Int,
    val description: String
        ) : Serializable
data class CheckListPoints(
    var correctly: Boolean,
    var requirement: String,
    var passed: Boolean,
): Serializable