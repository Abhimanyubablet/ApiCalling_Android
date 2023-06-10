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

class UserCustomAdapter(val context: Context, val DataList: List<DataModel>):BaseAdapter() {
    override fun getCount(): Int {
        return DataList.size
    }

    override fun getItem(position: Int): Any {
        return DataList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    @SuppressLint("ViewHolder", "MissingInflatedId")
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
      val rowView=LayoutInflater.from(context).inflate(R.layout.customerlistview,parent,false)


        val studentName=   rowView.findViewById<TextView>(R.id.student_name)
        val studentCourse=   rowView.findViewById<TextView>(R.id.student_course)
        val image1=   rowView.findViewById<ImageView>(R.id.image)
        studentName.text=DataList[position].name
        studentCourse.text= DataList[position].course
        val data=DataList[position]
        Glide.with(context).load(data.image).into(image1)
        return rowView
    }
}