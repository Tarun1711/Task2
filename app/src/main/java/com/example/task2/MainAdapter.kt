package com.example.task2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView

class MainAdapter(
    val context: Fragment1,
    val nameList: ArrayList<MainModel>,
    private var mListener: OnItemClickListener
) : RecyclerView.Adapter<MainAdapter.ItemViewHolder>() {

    lateinit var arrayList: ArrayList<String>
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item, parent, false)
        return ItemViewHolder(itemView)


    }

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<CheckBox>(R.id.name)
    }

    interface OnItemClickListener {
        fun onItemClick(nameList: MainModel, view: View)

    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        holder.name.text = nameList[position].name
        holder.name.setOnCheckedChangeListener(null);
//        holder.name.isChecked = false

        holder.itemView.setOnClickListener {
            mListener.onItemClick(nameList[position], it)
            holder.name.isChecked = true

        }

    }

    override fun getItemCount(): Int {
        return nameList.size
    }
}


