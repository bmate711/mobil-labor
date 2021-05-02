package com.example.testnavigation.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.testnavigation.R
import com.example.testnavigation.model.Meterage

class MeterageListAdapter(private val onClick: (Meterage) -> Unit):
        ListAdapter<Meterage, MeterageListAdapter.ListViewHolder>(ListDiffCallback) {

    class ListViewHolder(itemView: View, val onClick: (Meterage) -> Unit) :
            RecyclerView.ViewHolder(itemView) {
        private val title: TextView = itemView.findViewById(R.id.textViewTitle)
        private val date: TextView = itemView.findViewById(R.id.textViewDate)
        private val meterage1: TextView = itemView.findViewById(R.id.textViewList1)
        private val meterage2: TextView = itemView.findViewById(R.id.textViewList2)
        private val meterage3: TextView = itemView.findViewById(R.id.textViewList3)
        private val meterage4: TextView = itemView.findViewById(R.id.textViewList4)

        private  var currentMeterage: Meterage ?= null

        init {
            itemView.setOnClickListener {
                currentMeterage?.let {
                    onClick(it)
                }
            }
        }

        fun bind(meterage: Meterage) {
            currentMeterage = meterage

            title.text = meterage.license
            date.text = meterage.date.toString()
            meterage1.text = meterage?.values?.get(0)?.toString()
            meterage2.text = meterage?.values?.get(1)?.toString()
            meterage3.text = meterage?.values?.get(2)?.toString()
            meterage4.text = meterage?.values?.get(3)?.toString()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.list_item, parent, false)
        return ListViewHolder(view, onClick)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val flower = getItem(position)
        holder.bind(flower)

    }

}

object ListDiffCallback : DiffUtil.ItemCallback<Meterage>() {
    override fun areItemsTheSame(oldItem: Meterage, newItem: Meterage): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Meterage, newItem: Meterage): Boolean {
        return oldItem.id == newItem.id
    }
}