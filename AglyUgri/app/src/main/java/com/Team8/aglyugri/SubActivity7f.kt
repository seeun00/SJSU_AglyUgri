package com.Team8.aglyugri

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.Team8.aglyugri.databinding.ActivitySub7fBinding

import kotlinx.android.synthetic.main.activity_sub7f.*

private val proId = arrayListOf(R.id.pro1, R.id.pro2, R.id.pro3, R.id.pro4, R.id.pro5, R.id.pro6, R.id.pro7, R.id.pro8,
                        R.id.pro9, R.id.pro10, R.id.pro11, R.id.pro12, R.id.pro13, R.id.pro14, R.id.pro15, R.id.pro16)
private val proName = arrayListOf("avocado", "beet", "bellpepper", "broccoli", "cabbage", "carrot", "onion", "tomato", "apple", "banana", "cherry", "grape", "grapefruit", "orange", "peach", "pineapple")
private val productChkList = Array(16) {i -> false}
private var cnt = 0         //현재 선택된 상품 개수
private var max:Int = 12

class SubActivity7f : AppCompatActivity() {
    private val binding7 by lazy { ActivitySub7fBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding7.root)

        if(intent.getStringExtra("size") == "Big") max = 16
        else max = 12

        setData()

        with(binding7) {
            prev25.setOnClickListener {
                finish()
            }
            next25.setOnClickListener {
                if (cnt < 10) {
                    Toast.makeText(
                        this@SubActivity7f,
                        "The minimum number of selections is 10.",
                        Toast.LENGTH_LONG
                    ).show()
                } else {
                    val count = cnt
                    val thirdIntent = Intent(this@SubActivity7f, SubActivity7s::class.java)
                    thirdIntent.putExtra("size", intent.getStringExtra("size"))
                    thirdIntent.putExtra("count", "$count")
                    thirdIntent.putExtra("products", getList(productChkList))
                    startActivity(thirdIntent)
                }
            }
            pro1.setOnClickListener { changer(1) }
            pro2.setOnClickListener { changer(2) }
            pro3.setOnClickListener { changer(3) }
            pro4.setOnClickListener { changer(4) }
            pro5.setOnClickListener { changer(5) }
            pro6.setOnClickListener { changer(6) }
            pro7.setOnClickListener { changer(7) }
            pro8.setOnClickListener { changer(8) }
            pro9.setOnClickListener { changer(9) }
            pro10.setOnClickListener { changer(10) }
            pro11.setOnClickListener { changer(11) }
            pro12.setOnClickListener { changer(12) }
            pro13.setOnClickListener { changer(13) }
            pro14.setOnClickListener { changer(14) }
            pro15.setOnClickListener { changer(15) }
            pro16.setOnClickListener { changer(16) }
        }
    }
    private fun setData() {
        for(i in 0..15) {
            val v:LinearLayout = findViewById(proId[i])
            if(productChkList[i]) v.setBackgroundColor(Color.parseColor("#EAE9E7"))
            else v.setBackgroundColor(Color.parseColor("#4DFFFFFF"))
        }
    }
    private fun changer(i : Int) {
        var button: LinearLayout = findViewById(proId[i-1])
        if (!productChkList[i-1]) {
            if (cnt <= max) {
                button.setBackgroundColor(Color.parseColor("#EAE9E7"))
                productChkList[i-1] = true
                cnt++
            }
            else Toast.makeText(this, "Up to ${max}!!", Toast.LENGTH_SHORT)
        }
        else {
            if(cnt == max + 1) cnt = max
            button.setBackgroundColor(Color.parseColor("#4DFFFFFF"))
            productChkList[i-1] = false
            cnt--
        }
    }
    private fun getList(c:Array<Boolean>): String {
        var list = ""
        var a = 0
        for (i in 0..15) {
            if (c[i]) {
                list += proName[i] + "\t"
            }
        }
        return list
    }
}
