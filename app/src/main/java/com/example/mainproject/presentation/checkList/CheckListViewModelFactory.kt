package com.example.mainproject.presentation.checkList

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mainproject.domain.dbdata.CheckListModelDBDao
import java.lang.IllegalArgumentException

class CheckListViewModelFactory(private val dataSource: CheckListModelDBDao,private val application: Application): ViewModelProvider.Factory {
    @Suppress("uncheckes_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if(modelClass.isAssignableFrom(CheckListViewModel::class.java)){
            return CheckListViewModel(dataSource,application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }

}