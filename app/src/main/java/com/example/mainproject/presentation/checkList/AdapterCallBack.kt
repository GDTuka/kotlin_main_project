package com.example.mainproject.presentation.checkList

import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel

interface AdapterCallBack {
    fun onClick(model: CheckListWithCheckListModel)

    fun deleteCheckList(model: CheckListModel)
}