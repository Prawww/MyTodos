package com.example.myview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myview.Network.Todo

class Adapter(var todos : List<Todo>) : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_todo, parent,false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = todos[position]
        holder.userId.text = item.userId.toString()
        holder.id.text = item.id.toString()
        holder.title.text = item.title
        holder.isCompleted.text = item.isCompleted.toString()

    }

    override fun getItemCount(): Int {
        return todos.size

    }

    class ItemViewHolder(view : View) : RecyclerView.ViewHolder(view){
        var userId = view.findViewById<TextView>(R.id.textView)
        var id = view.findViewById<TextView>(R.id.textView2)
        var title = view.findViewById<TextView>(R.id.textView3)
        var isCompleted= view.findViewById<TextView>(R.id.textView4)

    }
}