package com.Team8.aglyugri

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.Team8.aglyugri.databinding.ActivityMain7Binding

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val binding by lazy { ActivityMain7Binding.inflate(layoutInflater) }

        super.onCreate(savedInstanceState)
        setContentView(binding.root)
// 0. 필요한 변수 설정
        // 0-1. 옵션 종류: "small" or "big"
        var check:String? = null

// 1.페이지 전환
        // 1-1. 메인화면으로 돌아가기: 경고창(Alert) 사용
        binding.exitBtn15.setOnClickListener {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Warning")
                .setMessage("Data will not be saved.Do you want to exit?")
                .setPositiveButton("Yes", DialogInterface.OnClickListener() { dialog, which ->
                        Toast.makeText(this, "Ordered was canceled.", Toast.LENGTH_SHORT).show()
                        finish()
                })
                .setNegativeButton("No", null)
                .show()
        }
        // 1-2. 다음페이지로 넘어가기: 알림(Toast) 사용
        val secondIntent = Intent(this, SubActivity7f::class.java)
        binding.nextBtn15.setOnClickListener {
            if(check == null) {         // 옵션 미선택시 경고창
                Toast.makeText(
                    binding.root.context,
                    "Please select the option.",
                    Toast.LENGTH_SHORT
                ).show()
            }
            else {                      // 옵션 선택시 데이터 전달 및 다음 페이지로 이동
                secondIntent.putExtra("size", check)
                startActivity(secondIntent)
            }
        }

// 2. 박스(옵션) 선택
        with(binding) {
            // 2-1. 작은상자 선택
            smallBox5.setOnClickListener {
                check = "Small"
                binding.smallBox5.setBackgroundResource(R.drawable.box_line)
                binding.bigBox5.setBackgroundResource(R.drawable.box_noline)
            }
            // 2-2. 큰상자 선택
            bigBox5.setOnClickListener {
                check = "Big"
                binding.bigBox5.setBackgroundResource(R.drawable.box_line)
                binding.smallBox5.setBackgroundResource(R.drawable.box_noline)

            }
        }
    }
}

