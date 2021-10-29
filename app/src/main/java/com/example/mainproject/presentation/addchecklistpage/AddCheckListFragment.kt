package com.example.mainproject.presentation.addchecklistpage

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.mainproject.R
import com.example.mainproject.data.model.CheckListModel
import com.example.mainproject.presentation.checkList.CheckListFragment
import kotlinx.android.synthetic.main.fragment_add_check_list.*


class AddCheckListFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_add_check_list, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val vm = ViewModelProvider(this).get(AddCheckListVM::class.java)

        
    }
    fun sendData(model: CheckListModel){
        var bundle = Bundle()
        bundle.putSerializable("data",model)
        var fragment = CheckListFragment()
        fragment.arguments = bundle
        parentFragmentManager.beginTransaction().replace(R.id.container, fragment)
    }
}