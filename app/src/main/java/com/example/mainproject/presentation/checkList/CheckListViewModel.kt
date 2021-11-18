package com.example.mainproject.presentation.checkList


import androidx.lifecycle.*
import com.example.mainproject.data.Repository
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.domain.dbdata.CheckListModelDBDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CheckListViewModel(private val database: CheckListModelDBDao,private val repository: Repository): ViewModel() {

    val checkLists : LiveData<List<CheckListWithCheckListModel>> = repository.allCheckList.asLiveData()

    fun deleteCheckList(model:CheckListWithCheckListModel){
        viewModelScope.launch(Dispatchers.IO) {
            database.deleteCheckList(model)
        }
    }

}