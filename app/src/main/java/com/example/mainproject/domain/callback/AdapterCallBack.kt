package com.example.mainproject.domain.callback

import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel

interface AdapterCallBack {
    fun onClick(model: CheckListWithCheckListModel)

    fun deleteCheckList(model: CheckListWithCheckListModel)
}