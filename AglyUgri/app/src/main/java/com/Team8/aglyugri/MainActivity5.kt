package com.Team8.aglyugri

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.drawerlayout.widget.DrawerLayout
import kotlinx.android.synthetic.main.activity_main3.*
import kotlinx.android.synthetic.main.activity_main5.*

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

        seed_cnt.text = ": ${SeedData.seeds}"

        apple_1.setOnClickListener {
            val nextIntent = Intent(this, SubActivity5::class.java)
            nextIntent.putExtra("image","apple")
            startActivity(nextIntent)
        }
        carrot_1.setOnClickListener {
            val nextIntent = Intent(this, SubActivity5::class.java)
            nextIntent.putExtra("image","carrot")
            startActivity(nextIntent)
        }
        grape_1.setOnClickListener {
            val nextIntent = Intent(this, SubActivity5::class.java)
            nextIntent.putExtra("image","grape")
            startActivity(nextIntent)
        }
        peach_1.setOnClickListener {
            val nextIntent = Intent(this, SubActivity5::class.java)
            nextIntent.putExtra("image","peach")
            startActivity(nextIntent)
        }


        //하단바
        btn_home2_5.setOnClickListener {
            val nextIntent = Intent(this, MainActivity2::class.java)
            startActivity(nextIntent)
        }
        btn_home3_5.setOnClickListener {
            val nextIntent = Intent(this, MainActivity3::class.java)
            startActivity(nextIntent)
        }

        btn_home5_5.setOnClickListener {
            val nextIntent = Intent(this, MainActivity5::class.java)
            startActivity(nextIntent)
        }

    }
}