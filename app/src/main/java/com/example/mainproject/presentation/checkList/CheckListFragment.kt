package com.example.mainproject.presentation.checkList


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mainproject.R
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.data.model.CheckListPoints
import com.example.mainproject.domain.AdapterCallBack
import com.example.mainproject.presentation.mainchecklistpage.MainCheckListPageFragment
import com.example.mainproject.presentation.mainchecklistpage.MainCheckListPageVM
import kotlinx.android.synthetic.main.fragment_checklist.*


class CheckListFragment : Fragment(),AdapterCallBack{



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checklist, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val vm = ViewModelProvider(this).get(CheckListViewModel::class.java)

        val adapter = CheckListAdapter(this)

        checkListRecyclerView.adapter = adapter

        addCheckList.setOnClickListener{
            adapter.items += vm.addCheckList()
        }

    }
    override fun onClick(model: CheckListModel) {
        var bundle = Bundle()
        bundle.putSerializable("data",model)
        val fragment = MainCheckListPageFragment()
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction().replace(R.id.container, fragment).commit()
    }

}