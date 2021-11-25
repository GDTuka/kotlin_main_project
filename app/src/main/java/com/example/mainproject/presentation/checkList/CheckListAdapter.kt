package com.example.mainproject.presentation.checkList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.mainproject.R
import com.example.mainproject.data.db.relations.CheckListWithCheckListModel
import com.example.mainproject.data.model.CheckListModel

class CheckListAdapter(val listener: CheckListFragment,) : RecyclerView.Adapter<CheckListAdapter.CheckListItem>() {

    var items: MutableList<CheckListWithCheckListModel> = mutableListOf()
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
        holder.itemView.setOnClickListener{
            listener.onClick(items[position])
        }
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
    fun removeAt(position: Int){
        listener.deleteCheckList(items[position].CheckList)
    }
    inner class CheckListItem(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var checkListName = itemView.findViewById<TextView>(R.id.name)
        var checkListDesc = itemView.findViewById<TextView>(R.id.description)
        var checkListResult = itemView.findViewById<TextView>(R.id.result)
        var checkListCount = itemView.findViewById<TextView>(R.id.count)

        fun bind(item: CheckListWithCheckListModel) {

            var checkListResultCounter = 0
            var checkListPassedCounter = 0
            for(checkListPoint in item.checkListPoints){
                if(checkListPoint.correctly == true){
                    checkListResultCounter++
                }
                if(checkListPoint.passed == true){
                    checkListPassedCounter++
                }
            }

            item.CheckList.checkListResult = (checkListResultCounter / item.checkListPoints.size) * 100
            item.CheckList.checkListCount = checkListPassedCounter
            checkListName.text = item.CheckList.checkListName
            checkListDesc.text = item.CheckList.description
            checkListResult.text = "Результат ${item.CheckList.checkListResult}/100"
            checkListCount.text = "Пройдено ${item.CheckList.checkListCount}/${item.checkListPoints.size}"
        }
    }
}