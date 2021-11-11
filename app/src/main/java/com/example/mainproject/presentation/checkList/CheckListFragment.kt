package com.example.mainproject.presentation.checkList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mainproject.R
import com.example.mainproject.data.db.db.CheckListDB
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.domain.callback.AdapterCallBack
import com.example.mainproject.presentation.mainchecklistpage.MainCheckListPageFragment
import kotlinx.android.synthetic.main.fragment_checklist.*


class CheckListFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checklist, container, false)

        val application = requireNotNull(this.activity).application
        val dataSource = CheckListDB.getInstance(application).CheckListDBDao()
        val viewModelFactory = CheckListViewModelFactory(dataSource,application)
        val vm = ViewModelProvider(this,viewModelFactory).get(CheckListViewModel::class.java)
        vm.onStartTracking()
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = ViewModelProvider(this).get(CheckListViewModel::class.java)
        vm.testData()
        testView.text = vm.testData
        val adapter = CheckListAdapter(this)

        checkListRecyclerView.adapter = adapter

        addCheckList.setOnClickListener{
            adapter.items += vm.addCheckList()
        }

    }

}