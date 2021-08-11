package com.Team8.aglyugri

import ViewPagerAdapter
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import androidx.drawerlayout.widget.DrawerLayout
import androidx.viewpager2.widget.ViewPager2
import kotlinx.android.synthetic.main.activity_main3.*


class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)



        viewPager.adapter = ViewPagerAdapter(getBannerList()) // 어댑터 생성
        viewPager.orientation = ViewPager2.ORIENTATION_HORIZONTAL // 방향을 가로로
        dots_indicator.setViewPager2(viewPager)

        // 전체화면인 DrawerLayout 객체 참조
        val drawerLayout = findViewById<View>(R.id.drawerLayout) as DrawerLayout

        // Drawer 화면(뷰) 객체 참조
        val drawerView = findViewById(R.id.drawer) as View


        // 드로어 화면을 열고 닫을 버튼 객체 참조
        val btnOpenDrawer = findViewById<View>(R.id.btn_slide_3) as ImageButton
        val btnCloseDrawer = findViewById<View>(R.id.btn_CloseDrawer_3) as Button


        // 드로어 여는 버튼 리스너
        btnOpenDrawer.setOnClickListener { drawerLayout.openDrawer(drawerView) }


        // 드로어 닫는 버튼 리스너
        btnCloseDrawer.setOnClickListener { drawerLayout.closeDrawer(drawerView) }

        // 페이지 이동
        btn_direct_trade_3.setOnClickListener {
            val nextIntent = Intent(this, MainActivity6::class.java)
            startActivity(nextIntent)
        }
        btn_subscription_3.setOnClickListener {
            val nextIntent = Intent(this, MainActivity7::class.java)
            startActivity(nextIntent)
        }

        btn_home2_3.setOnClickListener {
            val nextIntent = Intent(this, MainActivity2::class.java)
            startActivity(nextIntent)
        }

        btn_home3_3.setOnClickListener {
            val nextIntent = Intent(this, MainActivity3::class.java)
            startActivity(nextIntent)
        }

        btn_home5_3.setOnClickListener {
            val nextIntent = Intent(this, MainActivity5::class.java)
            startActivity(nextIntent)
        }




    }
    private fun getBannerList(): ArrayList<Int> {
        return arrayListOf<Int>(R.drawable.banner1, R.drawable.banner2, R.drawable.banner3, R.drawable.banner4)
    }
}

