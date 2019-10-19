package com.example.davalebagulisashvili

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.logging.Logger

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        plus.setOnClickListener {
            if (Number1.text.isEmpty() || Number2.text.isEmpty()) toast()
            else Calculate("+")
        }
        minus.setOnClickListener {
            if (Number1.text.isEmpty() || Number2.text.isEmpty()) toast()
            else Calculate("-")
        }
        divide.setOnClickListener {
            if (Number1.text.isEmpty() || Number2.text.isEmpty()) toast()
            else Calculate("/")
        }
        multiply.setOnClickListener {
            if (Number1.text.isEmpty() || Number2.text.isEmpty()) toast()
            else Calculate("*")
        }
    }
    private  fun toast(){
        Toast.makeText(this,"Please enter both numbers",Toast.LENGTH_SHORT).show()
    }

    private fun Calculate(Operation : String) {

        var result : String =""
        var FirstNumber :Int = Number1.text.toString().toInt()
        var SecondNumber :Int = Number2.text.toString().toInt()
        when (Operation) {
            "+" -> result = (FirstNumber + SecondNumber).toString()
            "-" -> result = (FirstNumber - SecondNumber).toString()
            "*" -> result = (FirstNumber * SecondNumber).toString()
            "/" -> result = (FirstNumber / SecondNumber).toString()
        }
        result = "$FirstNumber $Operation $SecondNumber = $result"

        val intent = Intent(this, SecondActivity::class.java)
        intent.putExtra("Result", result)
        startActivity(intent)
    }
}
