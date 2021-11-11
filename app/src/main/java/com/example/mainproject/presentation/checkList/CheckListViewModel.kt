package com.example.mainproject.presentation.checkList

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.domain.dbdata.CheckListModelDBDao
import kotlinx.coroutines.launch


class CheckListViewModel(val database: CheckListModelDBDao, application: Application): AndroidViewModel(application) {

    val checkList1 = CheckListModel("Door",0,0,"1234567890123456789012345")

    val checkListElem = MutableLiveData<CheckListModel>()
    init{
        initializeCheckListElem()
    }
    private fun initializeCheckListElem(){
        viewModelScope.launch {
            checkListElem.value = getCheckListFromDB()
        }
    }
    private  suspend fun getCheckListFromDB():CheckListModel?{
        var checkList = database.getEverything()
        return checkList
    }
    var testData: String = "1324"
    fun testData(){
        testData = "4321"
    }

    fun onStartTracking(){
        viewModelScope.launch {
            val newCheckList = CheckListModel("Door",2,0,"1234")
            insert(newCheckList)
            checkListElem.value = getCheckListFromDB()
        }
    }
    private  suspend fun insert(checkList:CheckListModel){
        database.insert(checkList)
    }
    fun addCheckList():CheckListModel{
        return checkList1
    }
}