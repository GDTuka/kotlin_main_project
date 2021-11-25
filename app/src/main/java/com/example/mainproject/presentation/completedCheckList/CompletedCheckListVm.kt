package com.example.mainproject.presentation.completedCheckList

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.mainproject.data.Repository
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.domain.dbdata.CheckListModelDBDao

class CompletedCheckListVm(private val database: CheckListModelDBDao,private val repository: Repository) : ViewModel(){

    val checkLists : LiveData<MutableList<CheckListWithCheckListModel>> = repository.allCheckList.asLiveData()

    fun getCompletedCheckList():MutableList<CheckListWithCheckListModel>{
        for(checkList in checkLists.value!!){
            for(checkListPoint in checkList.checkListPoints){
                if(checkListPoint)
            }
        }
    }

}