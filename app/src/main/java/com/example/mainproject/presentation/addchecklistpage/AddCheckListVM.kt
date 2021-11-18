package com.example.mainproject.presentation.addchecklistpage


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainproject.data.db.entitys.CheckListPoints
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.domain.dbdata.CheckListModelDBDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddCheckListVM (private val database: CheckListModelDBDao): ViewModel() {

    private var doorCheckListModel = CheckListModel("Дверь",0,0,"4321")
    private val doorCheckListPoint1 = CheckListPoints(false,"1",false)
    private val doorCheckListPoint2 = CheckListPoints(false,"2",false)
    private var doorListOfCheckListPoints = listOf<CheckListPoints>(doorCheckListPoint1,doorCheckListPoint2)
    private val  door = CheckListWithCheckListModel(doorCheckListModel,doorListOfCheckListPoints)

    private var windowCheckListModel = CheckListModel("Окно",0,0,"4321")
    private var windowCheckListPoint1 = CheckListPoints(false,"1",false)
    private var windowCheckListPoint2 = CheckListPoints(false,"1",false)
    private var windowListOfCheckListPoints = listOf<CheckListPoints>(windowCheckListPoint1,windowCheckListPoint2)
    private val window = CheckListWithCheckListModel(windowCheckListModel,windowListOfCheckListPoints)

    var checkLists = MutableLiveData<List<CheckListWithCheckListModel>>().apply {
        value = listOf(door,window)
    }

    fun addCheckList(name: String){
        viewModelScope.launch(Dispatchers.IO) {
            when (name) {
                "Дверь" -> insert(door)
                "Окно" -> insert(window)
            }
        }
    }

    private suspend fun insert(checkList: CheckListWithCheckListModel){
        database.insert(checkList)
    }
}