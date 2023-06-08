package com.example.apicallingpractise

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide

class CustomAdapter( val context: Context, val DataList:List<DataModel>):BaseAdapter() {
    override fun getCount(): Int {
        return DataList.size
    }

    override fun getItem(position: Int): Any {
        return DataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      val rowView=LayoutInflater.from(context).inflate(R.layout.customerlistview,parent,false)
        val image=rowView.findViewById<ImageView>(R.id.image)
        val data=DataList[position]
        Glide.with(context).load(data.image).into(image)
        val title=rowView.findViewById<TextView>(R.id.title)
        val description=rowView.findViewById<TextView>(R.id.description)
        title.setText(data.title)
        description.setText(data.desc)

        return rowView
    }
}