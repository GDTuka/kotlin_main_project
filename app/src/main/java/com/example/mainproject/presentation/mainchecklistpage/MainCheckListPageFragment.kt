package com.example.mainproject.presentation.mainchecklistpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.mainproject.R
import com.example.mainproject.data.db.entitys.CheckListPoints
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import kotlinx.android.synthetic.main.fragment_main_check_list_page.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainCheckListPageFragment : Fragment(), UpdateCheckList{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_main_check_list_page, container, false)


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vm by viewModel<MainCheckListPageVM>()
        val data: CheckListWithCheckListModel = this.requireArguments().getSerializable("checkList") as CheckListWithCheckListModel
        val adapter = MainCheckListPageAdapter(this)
        adapter.items = data.checkListPoints
        mainChecklistRecycler.adapter = adapter

    }

    override fun updateData(checkListPoints: CheckListPoints) {
        val vm by viewModel<MainCheckListPageVM>()
        vm.update(checkListPoints)
    }
}