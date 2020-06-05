package com.example.foody

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.room.Room
import kotlinx.android.synthetic.main.activity_registration.*

class Registration : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        var db = Room.databaseBuilder(this,AppDB :: class.java,"UserDb").fallbackToDestructiveMigration().build()

        txtsignin.setOnClickListener(){
            val i = Intent(this,MainActivity::class.java)
            startActivity(i)
        }

        btnreg.setOnClickListener(){
            Thread{
                var ent = User()
                ent.id=mobile_no.text.toString()
                ent.name=name.text.toString()
                ent.pass=password.text.toString()

                db.userDao().register(ent)
                val intent = Intent(this,HomeActivity::class.java)
                intent.putExtra("name",ent.name)
                intent.putExtra("mobilenumber",ent.id)
                intent.putExtra("password",ent.pass)
                startActivity(intent)

                runOnUiThread(){
                    Toast.makeText(this,"Registered Successfully",Toast.LENGTH_SHORT).show()
                }



            }.start()



        }
    }
}