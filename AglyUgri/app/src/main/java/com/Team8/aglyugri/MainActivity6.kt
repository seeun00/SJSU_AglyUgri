package com.Team8.aglyugri

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.SearchView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main6.*

class MainActivity6 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main6)

        btn_home2_6.setOnClickListener {
            val nextIntent = Intent(this, MainActivity2::class.java)
            startActivity(nextIntent)
        }

        btn_home3_6.setOnClickListener {
            val nextIntent = Intent(this, MainActivity3::class.java)
            startActivity(nextIntent)
        }

        btn_home5_6.setOnClickListener {
            val nextIntent = Intent(this, MainActivity5::class.java)
            startActivity(nextIntent)
        }
        ibtn_dday_onion3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Buy")
                .setMessage("Will you buy?")
                .setPositiveButton("Yes", DialogInterface.OnClickListener() { dialog, which ->
                    SeedData.getFromDirect(this)
                })
                .setNegativeButton("No", DialogInterface.OnClickListener() { dialog, which ->
                    Toast.makeText(this, "Cancled", Toast.LENGTH_SHORT)
                })
                .show()
        }
        ibtn_dday_potato3.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Buy")
                .setMessage("Will you buy?")
                .setPositiveButton("Yes", DialogInterface.OnClickListener() { dialog, which ->
                    SeedData.getFromDirect(this)
                })
                .setNegativeButton("No", DialogInterface.OnClickListener() { dialog, which ->
                    Toast.makeText(this, "Cancled", Toast.LENGTH_SHORT)
                })
                .show()
        }
        search.setOnQueryTextListener(object: SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                when(query){
                    "peach"-> txt_dDay_3.text="Peach Product"
                    "grape"-> txt_dDay_3.text="Grape Product"
                    "apple"-> txt_dDay_3.text="Apple Product"
                    "watermelon"-> txt_dDay_3.text="Watermelon Product"
                    "hallabong"-> txt_dDay_3.text="Hallabong Product"
                    "melon"-> txt_dDay_3.text="Melon Product"
                    "persimmon"-> txt_dDay_3.text="Persimmon Product"
                    "tomato"-> txt_dDay_3.text="Tomato Product"
                    "onion"-> txt_dDay_3.text="Onion Product"
                    "carrot"-> txt_dDay_3.text="Carrot Product"
                }
                when(query){
                    "peach"-> ibtn_dday_onion3.setImageResource(R.drawable.cheongdo_peach)
                    "grape"-> ibtn_dday_onion3.setImageResource(R.drawable.yeongdong_grape)
                    "apple"-> ibtn_dday_onion3.setImageResource(R.drawable.andong_apple)
                    "watermelon"-> ibtn_dday_onion3.setImageResource(R.drawable.gochang_watermelon)
                    "hallabong"-> ibtn_dday_onion3.setImageResource(R.drawable.jeju_hallabong)
                    "melon"-> ibtn_dday_onion3.setImageResource(R.drawable.seongju_melon)
                    "persimmon"-> ibtn_dday_onion3.setImageResource(R.drawable.yeongju_persimmon)
                    "tomato"-> ibtn_dday_onion3.setImageResource(R.drawable.suncheon_tomato)
                    "onion"-> ibtn_dday_onion3.setImageResource(R.drawable.muan_onion)
                    "carrot"-> ibtn_dday_onion3.setImageResource(R.drawable.jeju_carrot)
                }

                when(query){
                    "peach"-> ibtn_dday_potato3.setImageResource(R.drawable.cheongdo_peach)
                    "grape"-> ibtn_dday_potato3.setImageResource(R.drawable.yeongdong_grape)
                    "apple"-> ibtn_dday_potato3.setImageResource(R.drawable.andong_apple)
                    "watermelon"-> ibtn_dday_potato3.setImageResource(R.drawable.gochang_watermelon)
                    "hallabong"-> ibtn_dday_potato3.setImageResource(R.drawable.jeju_hallabong)
                    "melon"-> ibtn_dday_potato3.setImageResource(R.drawable.seongju_melon)
                    "persimmon"-> ibtn_dday_potato3.setImageResource(R.drawable.yeongju_persimmon)
                    "tomato"-> ibtn_dday_potato3.setImageResource(R.drawable.suncheon_tomato)
                    "onion"-> ibtn_dday_potato3.setImageResource(R.drawable.muan_onion)
                    "carrot"-> ibtn_dday_potato3.setImageResource(R.drawable.gimhae_carrot)
                }
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }

        })
    }
}