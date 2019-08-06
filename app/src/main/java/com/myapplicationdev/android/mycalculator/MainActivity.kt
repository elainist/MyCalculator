package com.myapplicationdev.android.mycalculator

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

class MainActivity : AppCompatActivity() {


    
    var sError : Boolean = false
    var num1 = ""
    var num2 = ""
    var operator = ""
    var ans = ""
    var newOp : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAC.setOnClickListener {
            this.textView.text = "0"
        }
    }

    fun onNum(view: View){

        if (newOp){
            textView.setText("")
        }
        newOp=false

        val selected = view as Button
        num1 = ""

        when (selected.id){
            btn0.id -> {
                num1 = "0"
            }
            btn1.id -> {
                num1 = "1"
            }
            btn2.id -> {
                num1 = "2"
            }
            btn3.id -> {
                num1 = "3"
            }
            btn4.id -> {
                num1 = "4"
            }
            btn5.id -> {
                num1 = "5"
            }
            btn6.id -> {
                num1 = "6"
            }
            btn7.id -> {
                num1 = "7"
            }
            btn8.id -> {
                num1 = "8"
            }
            btn9.id -> {
                num1 = "9"
            }
        }
        //textView.setText(num1)

        if (sError) {
            textView.setText(num1)
        }else {
            textView.append(num1)
        }
    }



    fun onOp(view:View){
        val selected = view as Button
        var operator = ""


        when (selected.id){
            btnAdd.id -> {
                operator = "+"
            }
            btnSub.id -> {
                operator = "-"
            }
            btnMultiply.id -> {
                operator = "*"
            }
            btnDiv.id -> {
                operator = "/"
            }
        }

        num1 = textView.text.toString()
    }

    fun onEquals(view:View){
        var num2 = textView.text.toString()
        var ans : Double?=null
        when(operator){
            "*"->{
                ans=num1.toDouble() * num2.toDouble()

            }
            "/"->{
                ans=num1.toDouble() / num2.toDouble()

            }
            "+"->{
                ans=num1.toDouble() + num2.toDouble()

            }
            "-"->{
                ans=num1.toDouble() - num2.toDouble()

            }

        }

        textView.setText(ans.toString())

    }
}
