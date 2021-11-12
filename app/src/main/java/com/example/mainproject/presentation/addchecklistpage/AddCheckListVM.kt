package com.example.mainproject.presentation.addchecklistpage


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.domain.dbdata.CheckListModelDBDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AddCheckListVM (private val database: CheckListModelDBDao): ViewModel() {

    private val  door = CheckListModel("Дверь",0,0,"фывафывафыв")
    private var window = CheckListModel("Окно",0,0,"4321")

    var checkLists = MutableLiveData<List<CheckListModel>>().apply {
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

    private suspend fun insert(checkList: CheckListModel){
        database.insert(checkList)
    }
}