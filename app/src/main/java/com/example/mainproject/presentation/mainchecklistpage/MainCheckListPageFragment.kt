package com.example.mainproject.presentation.mainchecklistpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModelProvider
import com.example.mainproject.R
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.presentation.checkList.CheckListViewModel
import kotlinx.android.synthetic.main.fragment_main_check_list_page.*


class MainCheckListPageFragment : Fragment() {


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
        val vm = ViewModelProvider(this).get(MainCheckListPageVM::class.java)
        val data: CheckListModel? = this.arguments?.getSerializable("data") as CheckListModel
        someTest.text = data?.checkListName
    }

}