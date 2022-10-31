package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    private lateinit var resultTextview: TextView
    private lateinit var numbers: TextView
    private lateinit var operation: String
    var operant: Double = 0.0
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

         resultTextview = findViewById(R.id.result)
            numbers = findViewById(R.id.numbers)

        }
    fun numberclick(clickedView: View) {
        if(clickedView is TextView) {

            var text = resultTextview.text.toString()
            var textN = numbers.text.toString()
            var number = clickedView.text.toString()

            if (text == "0" || textN == "0") {
                text = ""
                textN = ""
            }
            val result = text + number
            val resultN = textN + number
            resultTextview.text = result
            numbers.text = resultN
        }
    }
    fun operationclick(clickedView: View) {
        if(clickedView is TextView){
            var numresult = numbers.text.toString() + clickedView.text.toString()
            this.operation = clickedView.text.toString()
            this.operant = resultTextview.text.toString().toDouble()
            resultTextview.text = ""
            numbers.text = numresult + resultTextview.text
        }
    }
    fun equals(clickedView: View) {
        if (clickedView is TextView){
            val secondoperant = resultTextview.text.toString().toDouble()
            when (operation) {
                "+" -> resultTextview.text = (this.operant + secondoperant).toString()
                "-" -> resultTextview.text = (this.operant - secondoperant).toString()
                "/" -> resultTextview.text = (this.operant / secondoperant).toString()
                "X" -> resultTextview.text = (this.operant * secondoperant).toString()
            }
        }
    }
    fun delete (clickedView: View) {
        if (clickedView is TextView) {
            var text = resultTextview.text
            if (text.isNotEmpty()) {
                var result = text.dropLast(1)
                resultTextview.text = result
                numbers.text = result
            }
        }
    }
    fun clear (clickedView: View) {
        if (clickedView is TextView) {
            resultTextview.text = "0"
            numbers.text = "0"
        }
    }

}


