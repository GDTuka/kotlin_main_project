package com.example.mainproject.domain.callback

import com.example.mainproject.data.model.CheckListModel

interface AdapterCallBack {
    fun onClick(model: CheckListModel)

    fun deleteCheckList(model: CheckListModel)
}