package com.example.mainproject.presentation.checkList


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.R
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.presentation.addchecklistpage.AddCheckListActivity
import com.example.mainproject.presentation.mainchecklistpage.MainCheckListPageFragment
import kotlinx.android.synthetic.main.fragment_checklist.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class CheckListFragment : Fragment(), AdapterCallBack {
    val vm by viewModel<CheckListViewModel>()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_checklist, container, false)
        return view
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = CheckListAdapter(this)

        checkListRecyclerView.adapter = adapter

        vm.checkLists.observe(viewLifecycleOwner,{
            adapter.items = it
        })

        addCheckList.setOnClickListener{
            val intent = Intent(context,AddCheckListActivity::class.java)
            startActivity(intent)
        }

        val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                    adapter.removeAt(viewHolder.bindingAdapterPosition)

            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(checkListRecyclerView)

    }

    override fun onClick(model: CheckListWithCheckListModel) {
        var bundle = Bundle()
        var fragment = MainCheckListPageFragment()
        bundle.putSerializable("checkList", model)
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction().replace(R.id.container,fragment).commit()

    }
    override fun deleteCheckList(model: CheckListModel) {
        vm.deleteCheckList(model)
    }
}