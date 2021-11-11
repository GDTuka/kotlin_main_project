package com.example.mainproject.presentation.checkList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.R
import com.example.mainproject.data.model.CheckListModel

class CheckListAdapter(val listener: CheckListFragment) : RecyclerView.Adapter<CheckListAdapter.CheckListItem>() {

    var items: List<CheckListModel> = listOf()
    set(value){
        field = value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CheckListItem {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.item_checklist, parent, false)
        return CheckListItem(view)
    }

    override fun onBindViewHolder(holder: CheckListItem, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class CheckListItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkListName = itemView.findViewById<TextView>(R.id.name)
        var checkListDesc = itemView.findViewById<TextView>(R.id.description)
        var checkListResult = itemView.findViewById<TextView>(R.id.result)
        var checkListCount = itemView.findViewById<TextView>(R.id.count)
        fun bind(item: CheckListModel) {
            checkListName.text = item.checkListName
            checkListDesc.text = item.description
            checkListResult.text = "Результат ${item.checkListResult.toString()}/100"
            checkListCount.text = "Пройдено 0/${item.checkListCount.toString()}"
        }
    }
}