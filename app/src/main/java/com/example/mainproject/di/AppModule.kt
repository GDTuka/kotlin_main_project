package com.example.mainproject

import android.app.Application
import com.example.mainproject.data.Repository
import com.example.mainproject.data.db.db.CheckListDB
import com.example.mainproject.domain.dbdata.CheckListModelDBDao
import com.example.mainproject.presentation.addchecklistpage.AddCheckListVM
import com.example.mainproject.presentation.checkList.CheckListAdapter
import com.example.mainproject.presentation.checkList.CheckListViewModel
import com.example.mainproject.presentation.mainchecklistpage.MainCheckListPageVM
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val appModule = module{

    viewModel{
        CheckListViewModel(get(),get())
    }
    viewModel {
        AddCheckListVM(get())
    }
    viewModel {
        MainCheckListPageVM(get())
    }
    single<CheckListModelDBDao> {
        CheckListDB.getInstance(androidApplication()).checkListDBDao()
    }
    single<Repository>{
        Repository(get())
    }

}