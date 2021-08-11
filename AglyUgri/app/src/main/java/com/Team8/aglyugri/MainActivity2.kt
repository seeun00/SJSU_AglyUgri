package com.Team8.aglyugri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.Team8.aglyugri.model.UserData
import com.Team8.aglyugri.view.UserAdapter
import kotlinx.android.synthetic.main.activity_main2.*

private lateinit var userList:ArrayList<UserData>

class MainActivity2 : AppCompatActivity() {
    private lateinit var addsBtn:FloatingActionButton
    private lateinit var recv:RecyclerView
    private lateinit var userAdapter:UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        /**set List*/
        userList = ArrayList()
        /**set find Id*/
        addsBtn = findViewById(R.id.addingBtn2)
        recv = findViewById(R.id.mRecycler)
        /**set Adapter*/
        userAdapter = UserAdapter(this,userList)
        /**setRecycler view Adapter*/
        recv.layoutManager = LinearLayoutManager(this)
        recv.adapter = userAdapter
        /**set Dialog*/
        addsBtn.setOnClickListener { addInfo() }

        btn_home2_2.setOnClickListener {
            val nextIntent = Intent(this, MainActivity2::class.java)
            startActivity(nextIntent)
        }

        btn_home3_2.setOnClickListener {
            val nextIntent = Intent(this, MainActivity3::class.java)
            startActivity(nextIntent)
        }

        btn_home5_2.setOnClickListener {
            val nextIntent = Intent(this, MainActivity5::class.java)
            startActivity(nextIntent)
        }

    }

    private fun addInfo() {
        val inflter = LayoutInflater.from(this)
        val v = inflter.inflate(R.layout.add_item,null)
        /**set view*/
        val userName = v.findViewById<EditText>(R.id.userName2)
        val userNo = v.findViewById<EditText>(R.id.userNo2)
        val userRating = v.findViewById<RatingBar>(R.id.userRating2)
        val addDialog = AlertDialog.Builder(this)

        addDialog.setView(v)
            .setPositiveButton("Ok"){ dialog,_->
            val names = userName.text.toString()
            val number = userNo.text.toString()
            val rating = userRating.rating


            userList.add(UserData("Name: $names","Review : $number", rating))
            userAdapter.notifyDataSetChanged()
            Toast.makeText(this,"Adding User Information Success",Toast.LENGTH_SHORT).show()
            dialog.dismiss()
                SeedData.getFromReview(this)
            }
            .setNegativeButton("Cancel"){
                dialog,_->
            dialog.dismiss()
            Toast.makeText(this,"Cancel",Toast.LENGTH_SHORT).show()
            }
            .create()
            .show()
    }
    /**ok now run this */

}