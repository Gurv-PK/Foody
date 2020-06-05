package com.example.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.provider.DocumentsContract
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_registration.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var c:Int = 0
        val db = Room.databaseBuilder(this,AppDB::class.java,"UserDb").fallbackToDestructiveMigration().build()
        val ent = User()
        txtsignup.setOnClickListener(){
            val i = Intent(this,Registration::class.java)
            startActivity(i)
        }

        btnlog.setOnClickListener(){

            if(lname.equals("") && lpassword.equals(""))
            {
                Toast.makeText(this,"Please Fill Credentials",Toast.LENGTH_SHORT).show()
            }
            else
            {
                Thread{

                    db.userDao().read().forEach {
                        if(it.name.equals(lname.text.toString()) && it.pass.equals(lpassword.text.toString()) ){


                            val pref = PreferenceManager.getDefaultSharedPreferences(this)
                            pref.apply {
                                val spname = getString("NAME","")
                                val spid = getString("ID","")
                                val pass = getString("password","")
                            }

                            val editor = pref.edit()

                            editor
                                .putString("Name",it.name)
                                .putString("id",it.id)
                                .putString("password",it.pass)
                                .apply()
                            runOnUiThread(){
                                Toast.makeText(this,"Login Succesfull",Toast.LENGTH_SHORT).show()
                            }
                            Log.i("id", it.id)
                            Log.i("name", it.name)
                            Log.i("pass", it.pass)
                            c=1

                            val intent=Intent(this,HomeActivity::class.java)
                            intent.putExtra("name",it.name)
                            intent.putExtra("mobilenumber",it.id)
                            intent.putExtra("password",it.pass)
                            startActivity(intent)
                        }
                    }
                    if(c!=1){
                        runOnUiThread(){
                            Toast.makeText(this,"Login Unsuccesfull",Toast.LENGTH_SHORT).show()
                        }
                    }

                }.start()

            }
        }
    }


}