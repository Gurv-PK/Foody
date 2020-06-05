package com.example.foody

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    lateinit var itemlist: ArrayList<FoodItems>
    lateinit var adaptor: Adaptor
    lateinit var recyclerViews: RecyclerView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_home, container, false)

        recyclerViews = root.findViewById(R.id.recyclerview)


        recyclerViews.apply {
            layoutManager = LinearLayoutManager(root.context)
            adaptor = Adaptor()
            adapter = adaptor

        }
        val data = DataSource.createdata()
        adaptor.submitList(data)




//        recyclelayoutManager = LinearLayoutManager(root.context)
//        recyclerview.addItemDecoration(DividerItemDecoration(root.context,1))
//        recyclerview.adapter = Adaptor(itemlist)



        // Inflate the layout for this fragment
        return root
    }


}