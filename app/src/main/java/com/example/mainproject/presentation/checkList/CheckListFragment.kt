package com.example.mainproject.presentation.checkList


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.mainproject.R
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.domain.callback.AdapterCallBack
import com.example.mainproject.presentation.addchecklistpage.AddCheckListActivity
import kotlinx.android.synthetic.main.fragment_checklist.*
import org.koin.androidx.viewmodel.ext.android.viewModel


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
        val vm by viewModel<CheckListViewModel>()
        val adapter = CheckListAdapter(this)

        checkListRecyclerView.adapter = adapter

        vm.checkLists.observe(viewLifecycleOwner,{
            adapter.items = it
        })
        addCheckList.setOnClickListener{
            val intent = Intent(context,AddCheckListActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onClick(model: CheckListWithCheckListModel) {

    }
    override fun deleteCheckList(model:CheckListWithCheckListModel){
        val vm by viewModel<CheckListViewModel>()
    }
}