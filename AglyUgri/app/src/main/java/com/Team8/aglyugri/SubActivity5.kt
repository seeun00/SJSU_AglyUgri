package com.Team8.aglyugri

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main5.*
import kotlinx.android.synthetic.main.activity_sub5.*
import kotlin.concurrent.timer

class SubActivity5 : AppCompatActivity() {
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub5)

        var imgName=intent.getStringExtra("image")
        when(imgName){
            "peach"-> invest_image3.setImageResource(R.drawable.cheongdo_peach)
            "grape"-> invest_image3.setImageResource(R.drawable.yeongdong_grape)
            "apple"-> invest_image3.setImageResource(R.drawable.andong_apple)
            "watermelon"-> invest_image3.setImageResource(R.drawable.gochang_watermelon)
            "hallabong"-> invest_image3.setImageResource(R.drawable.jeju_hallabong)
            "melon"-> invest_image3.setImageResource(R.drawable.seongju_melon)
            "persimmon"-> invest_image3.setImageResource(R.drawable.yeongju_persimmon)
            "tomato"-> invest_image3.setImageResource(R.drawable.suncheon_tomato)
            "onion"-> invest_image3.setImageResource(R.drawable.muan_onion)
            "carrot"-> invest_image3.setImageResource(R.drawable.jeju_carrot)
        }
        when(imgName){
            "peach"-> txt_agriCountry3.text = "Gyeonbuk Cheongdo"
            "grape"-> txt_agriCountry3.text = "Gyeonbuk Andong"
            "apple"-> txt_agriCountry3.text = "Gyeonbuk Andong"
            "watermelon"-> txt_agriCountry3.text = "Jeonbuk Gochang"
            "hallabong"-> txt_agriCountry3.text = "Jeju Island"
            "melon"-> txt_agriCountry3.text = "Gyeonbuk Seongju"
            "persimmon"-> txt_agriCountry3.text = "Gyeonbuk Yeongju"
            "tomato"-> txt_agriCountry3.text = "Jeonnam Suncheon"
            "onion"-> txt_agriCountry3.text = "[Jeonnam Muan"
            "carrot"-> txt_agriCountry3.text = "Jeju Island"


        }
        when(imgName){
            "peach"-> txt_agriName3.text = "Peach"
            "grape"-> txt_agriName3.text = "Grape"
            "apple"-> txt_agriName3.text = "Apple"
            "watermelon"-> txt_agriName3.text = "Watermelon"
            "hallabong"-> txt_agriName3.text = "Hallabong"
            "melon"-> txt_agriName3.text = "Melon"
            "persimmon"-> txt_agriName3.text = "Persimmon"
            "tomato"-> txt_agriName3.text = "Tomato"
            "onion"-> txt_agriName3.text = "Onion"
            "carrot"-> txt_agriName3.text = "Carrot"

        }

        when(imgName){
            "peach"-> txt_leftday3.text = "3Day 4Hours 29Minutes"
            "grape"-> txt_leftday3.text = "0Day 5Hours 03Minutes"
            "apple"-> txt_leftday3.text = "1Day 14Hours 58Minutes"
            "watermelon"-> txt_leftday3.text = "13Day 15Hours 47Minutes"
            "hallabong"-> txt_leftday3.text = "7Day 10Hours 28Minutes"
            "melon"-> txt_leftday3.text = "8Day 23Hours 33Minutes"
            "persimmon"-> txt_leftday3.text = "2Day 18Hours 49Minutes"
            "tomato"-> txt_leftday3.text = "4Day 21Hours 54Minutes"
            "onion"-> txt_leftday3.text = "12Day 12Hours 42Minutes"
            "carrot"-> txt_leftday3.text = "6Day 2Hours 59Minutes"

        }


        invest3.setOnClickListener{
            val cnt = Integer.parseInt(getInvest3.text.toString())
            if(cnt <= SeedData.getSeedCnd()) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Confirm Invest")
                builder.setMessage("Would you like to proceed with the investment?")
                builder.setPositiveButton("YES") { _, _ ->

                    Toast.makeText(applicationContext, "Investment completed: ${cnt} Seeds", Toast.LENGTH_SHORT)
                        .show()
                    SeedData.useSeeds(cnt)
                    startActivity(Intent(this, MainActivity5::class.java))
                }
                builder.setNegativeButton("No") { _, _ ->
                    Toast.makeText(
                        applicationContext,
                        "You cancelled Investment.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                builder.setNeutralButton("Cancel") { _, _ ->
                    Toast.makeText(
                        applicationContext,
                        "You cancelled the dialog.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                builder.show()
            }
            else {
                Toast.makeText(this, "Insufficient Seed...", Toast.LENGTH_SHORT)
            }
        }


        progressBar.max = 500
        var second=0

        timer(period = 100,initialDelay = 1000){
            second++
            progressBar.progress=second
        }




        //하단바
        btn_home2_5_1.setOnClickListener {
            val nextIntent = Intent(this, MainActivity2::class.java)
            startActivity(nextIntent)
        }

        btn_home3_5_1.setOnClickListener {
            val nextIntent = Intent(this, MainActivity3::class.java)
            startActivity(nextIntent)
        }

        btn_home5_5_1.setOnClickListener {
            val nextIntent = Intent(this, MainActivity5::class.java)
            startActivity(nextIntent)
        }

    }
}