package com.example.mainproject.presentation.addchecklistpage

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.R
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel

class AddCheckListAdapter(val listener: AddCheckListCallBack): RecyclerView.Adapter<AddCheckListAdapter.AddCheckListItem>() {


    var items: List<CheckListModel> = listOf()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AddCheckListItem {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_add_checklist_recycler, parent, false)
        return AddCheckListItem(view)
    }

    override fun onBindViewHolder(holder: AddCheckListItem, position: Int) {
        holder.itemView.setOnClickListener{
            listener.addCheckList(items[position])
        }
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class AddCheckListItem(itemView: View): RecyclerView.ViewHolder(itemView){

        var textView = itemView.findViewById<TextView>(R.id.checkListName)
        fun bind(model: CheckListModel){
            textView.text = model.checkListName
        }
    }
}