package com.example.foody

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar

class Logout : Fragment() {

     lateinit var pp:ProgressBar


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        var  root = inflater.inflate(R.layout.fragment_logout, container, false)

        var i= Intent(root.context,MainActivity::class.java)
        startActivity(i)

        return root
    }


}