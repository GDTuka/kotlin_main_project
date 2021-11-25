package com.example.mainproject.data

import androidx.annotation.WorkerThread
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.domain.dbdata.CheckListModelDBDao
import kotlinx.coroutines.flow.Flow


class Repository (private val checkListDao: CheckListModelDBDao){

    val allCheckList: Flow<MutableList<CheckListWithCheckListModel>> = checkListDao.getEverything()



}