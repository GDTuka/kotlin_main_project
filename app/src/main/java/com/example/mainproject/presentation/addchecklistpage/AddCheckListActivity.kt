package com.example.mainproject.presentation.addchecklistpage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mainproject.R
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel
import kotlinx.android.synthetic.main.activity_add_check_list.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class AddCheckListActivity: AppCompatActivity(), AddCheckListCallBack {

    override fun onCreate(savedInstanceState: Bundle?,) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_check_list)

        val vm by viewModel<AddCheckListVM>()
        val adapter = AddCheckListAdapter(this)
        addCheckList.adapter = adapter

        vm.checkLists.observe(this, {
            adapter.items = it
        })

    }

    override fun addCheckList(model: CheckListWithCheckListModel) {
        val vm by viewModel<AddCheckListVM>()
        vm.addCheckList(model.CheckList.checkListName)
        finish()
    }
}