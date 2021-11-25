package com.example.mainproject.presentation.mainchecklistpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.R
import com.example.mainproject.data.db.entitys.CheckListPoints
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import kotlinx.android.synthetic.main.item_main_check_list_page.view.*

class MainCheckListPageAdapter(val listener: MainCheckListPageFragment) : RecyclerView.Adapter<MainCheckListPageAdapter.MainCheckListItem>() {

    var items: List<CheckListPoints> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainCheckListItem {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_main_check_list_page, parent, false)
        return MainCheckListItem(view)
    }

    override fun onBindViewHolder(holder: MainCheckListItem, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class MainCheckListItem(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bind(item: CheckListPoints){
            itemView.requirement.text = item.requirement
            if(item.passed) {
                if (item.correctly) {
                    itemView.checkBoxYes.isChecked = true
                } else {
                    itemView.checkboxNo.isChecked = true
                }
            }
            itemView.checkBoxYes.setOnClickListener{
                item.correctly = true
                item.passed = true
                listener.updateData(item)
                itemView.checkboxNo.isChecked = false

            }
            itemView.checkboxNo.setOnClickListener{
                item.correctly = false
                item.passed = true
                listener.updateData(item)
                itemView.checkBoxYes.isChecked = false
            }

        }
    }
}