package com.example.mainproject.presentation.completedCheckList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.R
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel

class CompletedCheckListAdapter():RecyclerView.Adapter<CompletedCheckListAdapter.AdapterItem>() {
    var items: List<CheckListWithCheckListModel> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterItem {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_completed_check_list_recycler, parent, false)
        return AdapterItem(view)
    }

    override fun onBindViewHolder(holder: AdapterItem, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
    inner class AdapterItem(itemView: View): RecyclerView.ViewHolder(itemView){

            fun bind(model: CheckListWithCheckListModel){

            }
    }
}