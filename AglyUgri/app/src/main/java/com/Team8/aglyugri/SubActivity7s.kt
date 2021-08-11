package com.Team8.aglyugri

import android.app.AlertDialog
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import java.util.*
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sub7s.*

data class Credit(var num:String = "", var validity:String = "", var cvc:String = "", var password:String = "")
data class Submission(var option:String = "", var productList: String = "", var date: String = "", var destination: String = "", var credit:Credit = Credit())

private var checked = false
private var weeklist = arrayListOf<Int>(0, 0, 0, 0, 0, 0, 0)
private var submission = Submission()
private val weekId = arrayListOf(R.id.sunBtn_5, R.id.monBtn_5, R.id.tueBtn_5, R.id.wedBtn_5, R.id.thuBtn_5, R.id.friBtn_5, R.id.satBtn_5)
private val dateId = arrayListOf(R.id.sunDate_5, R.id.monDate_5, R.id.tueDate_5, R.id.wedDate_5, R.id.thuDate_5, R.id.friDate_5, R.id.satDate_5)

class SubActivity7s : AppCompatActivity() {
    private var deliveryday = ""
    private var address = ""
    private var detail = ""
    private var destination = ""
    private var n1 = ""
    private var n2 = ""
    private var n3 = ""
    private var n4 = ""
    private var credit = Credit()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sub7s)

        val size:String = intent.getStringExtra("size").toString()
        val list: String = intent.getStringExtra("products").toString()
        val cnt:Int = Integer.parseInt(intent.getStringExtra("count"))

        setData(list, cnt, size)

        prev3_5.setOnClickListener {
            val destination = address + detail
            credit.num = "${n1} - ${n2} - ${n3} - ${n4}"
            submission = Submission(size, list, deliveryday, destination, credit)
            finish()
        }
        cmpl3_5.setOnClickListener {
            val builder = AlertDialog.Builder(this@SubActivity7s)
            val nextIntent = Intent(this@SubActivity7s, MainActivity3::class.java)

            destination = address + detail
            credit.num = "${n1} - ${n2} - ${n3} - ${n4}"
            submission = Submission(size, list, deliveryday, destination, credit)
            submission = Submission(size, list, deliveryday, address + detail, credit)

            builder.setTitle("Warning")
                .setMessage("Do you want to submit?\nAfter submission, you can't modify.\nPlease check it again.")
                .setPositiveButton("Yes", DialogInterface.OnClickListener() { _, _ ->
                    Toast.makeText(this@SubActivity7s, "Ordered was submitted.", Toast.LENGTH_SHORT).show()
                    SeedData.getFromSubscrip(size, this@SubActivity7s)
                    startActivity(nextIntent)
                })
                .setNegativeButton("No", null)
                .show()
        }
            details_5.setOnEditorActionListener { _, _, _ ->
                address = details_5.text.toString()
                true
            }
            address_5.setOnEditorActionListener { _, _, _ ->
                detail = address_5.text.toString()
                true
            }
            numEdit15.setOnEditorActionListener { _, _, _ ->
                n1 = numEdit15.text.toString()
                true
            }
            numEdit25.setOnEditorActionListener { _, _, _ ->
                n2 = numEdit25.text.toString()
                true
            }
            numEdit35.setOnEditorActionListener { _, _, _ ->
                n3 = numEdit35.text.toString()
                true
            }
            numEdit45.setOnEditorActionListener { _, _, _ ->
                n4 = numEdit45.text.toString()
                true
            }
            dateEdit5.setOnEditorActionListener {_, _, _ ->
                credit.validity = dateEdit5.text.toString()
                true
            }
            cvcEdit5.setOnEditorActionListener { _, _, _ ->
                credit.cvc = cvcEdit5.text.toString()
                true
            }
            passEdit5.setOnEditorActionListener { _, _, _ ->
                credit.password = passEdit5.text.toString()
                true
        }
        sunBtn_5.setOnClickListener {
            if(changer(0)) textView_5.text = "your shippding date : ${sunDate_5.text}"
        }
        monBtn_5.setOnClickListener{
            if(changer(1)) textView_5.text = "your shippding date : ${monDate_5.text}"
        }
        tueBtn_5.setOnClickListener{
            if(changer(2)) textView_5.text = "your shippding date : ${tueDate_5.text}"
        }
        wedBtn_5.setOnClickListener{
            if(changer(3)) textView_5.text = "your shippding date : ${wedDate_5.text}"
        }
        thuBtn_5.setOnClickListener{
            if(changer(4)) textView_5.text = "your shippding date : ${thuDate_5.text}"
        }
        friBtn_5.setOnClickListener{
            if(changer(5)) textView_5.text = "your shippding date : ${friDate_5.text}"
        }
        satBtn_5.setOnClickListener{
            if(changer(6)) textView_5.text = "your shippding date : ${satDate_5.text}"
        }
    }
    private fun changer(i: Int) : Boolean{
        var b:TextView = findViewById(weekId[i])
        if (!checked) {
            b.setTextColor(Color.parseColor("#6B7275"))
            weeklist[i]++
            checked = true
            deliveryday = b.text.toString()
        }
        else if(weeklist[i] == 0) { return false }
        else {
            b.setTextColor(Color.parseColor("#CDD5D3"))
            weeklist[i]--
            deliveryday = ""
            checked = false
        }
        return true
    }
    private fun String.toEditable(): Editable =  Editable.Factory.getInstance().newEditable(this)
    private fun setData(list:String, cnt:Int, size:String) {
        size_text.text = "Size = ${size}: ${cnt}"
        product_list.text = list

        val day = Calendar.getInstance()
        val month = day.get(Calendar.MONTH) + 1
        var date = day.get(Calendar.DATE)
        var dow = day.get(Calendar.DAY_OF_WEEK) - 1
        for(i in 0.. 6) {
            val dateText:TextView = findViewById(dateId[(dow + i) % 7])
            dateText.text = "0${month}/${date + 7}"
            date++
        }

        if(checked) {
            for (i in 0..6) {
                if (weeklist[i] == 1) {
                    val b: Button = findViewById(weekId[i])
                    val d: TextView = findViewById(dateId[i])
                    b.setTextColor(Color.parseColor("#6B7275"))
                    textView_5.text = "your shippding date : ${d.text}"
                    break
                }
            }
        }

            details_5.text = address.toEditable()
            address_5.text = detail.toEditable()
            numEdit15.text = n1.toEditable()
            numEdit25.text = n2.toEditable()
            numEdit35.text = n3.toEditable()
            numEdit45.text = n4.toEditable()
            dateEdit5.text = credit.validity.toEditable()
            cvcEdit5.text = credit.cvc.toEditable()
            passEdit5.text = credit.password.toEditable()

    }
}


