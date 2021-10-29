package com.example.mainproject.domain

import com.example.mainproject.data.model.CheckListModel

interface AdapterCallBack {
    fun onClick(model: CheckListModel)
}