package com.example.mainproject.presentation.addchecklistpage

import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel

interface AddCheckListCallBack {
    fun addCheckList(model:CheckListWithCheckListModel)
}