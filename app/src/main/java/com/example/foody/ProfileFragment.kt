package com.example.foody

import android.content.Intent
import android.os.Build.USER
import android.os.Bundle
import android.preference.PreferenceManager
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_profile.*

class ProfileFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root = inflater.inflate(R.layout.fragment_profile, container, false)
        val p = activity?.intent?.extras


        Log.i("Profile Name",p?.get("name").toString())
        Log.i("Profile Pass",p?.get("password").toString())
        Log.i("Profile ID",p?.get("mobilenumber").toString())

        var piname = p?.get("name").toString()
        var ppasss = p?.get("password").toString()
        var pid = p?.get("mobilenumber").toString()

        Log.i("Profile Name",piname)
        Log.i("Profile Pass",ppasss)
        Log.i("Profile ID",pid)

        var prntext: EditText = root.findViewById(R.id.prname)
        var prptext: EditText = root.findViewById(R.id.password)
        var pritext: EditText = root.findViewById(R.id.pmob)

       prntext.setText(piname)
        prptext.setText(ppasss)
        pritext.setText(pid)


        return root
    }


}

