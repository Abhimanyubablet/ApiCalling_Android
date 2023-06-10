package com.example.apicallingpractise

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class StudentDetailsFragment : Fragment() {
     lateinit var listView: ListView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rowView= inflater.inflate(R.layout.fragment_student_details, container, false)
           listView=rowView.findViewById(R.id.ListView)
        return  rowView
//        val Data= arrayListOf<DataModel>(
//            DataModel("Bobby","admission open","https://media.yourobserver.com/img/photos/2023/04/25/img-homepage-meta_0_t1100.jpeg?31a214c4405663fd4bc7e33e8c8cedcc07d61559"),
//            DataModel("Abhimanyu","My Dream", "https://www.imgcorporations.com/images/bg-img.jpg"),
//            DataModel("Rahul","My Dream", "https://www.imgcorporations.com/images/bg-img.jpg")
//        )
//
//        val ListView=rowView.findViewById<ListView>(R.id.ListView)
//        val adapter= activity?.let { CustomAdapter(it,Data) }
//        ListView.adapter=adapter



//      return rowView
    }


    override fun onStart() {
        super.onStart()


        ApiCalling.create().getUser()
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe{  result ->
                listView.adapter= activity?.let { UserCustomAdapter(it,result) }
    }

    }




}



