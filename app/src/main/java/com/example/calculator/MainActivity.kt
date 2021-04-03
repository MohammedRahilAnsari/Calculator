package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.calculator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

    }

    fun btnNumberEvent(view: View) {
        //if(isNewOP ==true) is simplified and default value of the object is true
        if(isNewOP){
            binding.etDisplay.setText("")}
        isNewOP=false
        val btnSelect = view as Button
        var btnClickValue:String = binding.etDisplay.text.toString()
        when (btnSelect.id) {
            binding.btn0.id ->{btnClickValue+="0"}
            binding.btn1.id ->{btnClickValue+="1"}
            binding.btn2.id ->{btnClickValue+="2"}
            binding.btn3.id ->{btnClickValue+="3"}
            binding.btn4.id ->{btnClickValue+="4"}
            binding.btn5.id ->{btnClickValue+="5"}
            binding.btn6.id ->{btnClickValue+="6"}
            binding.btn7.id ->{btnClickValue+="7"}
            binding.btn8.id ->{btnClickValue+="8"}
            binding.btn9.id ->{btnClickValue+="9"}
            binding.btnDot.id ->{/*avoid repeating value*/btnClickValue+="."}
            binding.btnPlusMinus.id ->{btnClickValue = "-"+ btnClickValue}
        }
     binding.etDisplay.setText(btnClickValue)
    }

    //op = operation
    var op="*"
    var oldNumber=""
    var isNewOP=true;
    fun btnLogicEvent(view: View) {
        val btnSelect = view as Button
        var btnClickValue:String = binding.etDisplay.text.toString()
        when(btnSelect.id){
            binding.btnDivide.id ->{ btnClickValue += "/"
                op="/" }
            binding.btnMultiply.id ->{ op="*"
                btnClickValue += "x"}
            binding.btnMinus.id ->{ op="-"
                btnClickValue += "-"}
            binding.btnPlus.id ->{ op="+"
                btnClickValue += "+"}
        }
        oldNumber=binding.etDisplay.text.toString()
        isNewOP=true
    }

    fun btnEqualEvent(view: View) {
        val newNumber=binding.etDisplay.text.toString()
        var finalNumber:Double?=null
        when(op) {
            "/" -> {
                finalNumber = oldNumber.toDouble() / newNumber.toDouble()
            }
            "*" -> {
                finalNumber = oldNumber.toDouble() * newNumber.toDouble()
            }
            "-" -> {
                finalNumber = oldNumber.toDouble() - newNumber.toDouble()
            }
            "+" -> {
                finalNumber = oldNumber.toDouble() + newNumber.toDouble()
            }
        }
        binding.etDisplay.setText(finalNumber.toString())
        isNewOP=true
    }

    fun btnModuleEvent(view: View) {
        val number:Double=binding.etDisplay.text.toString().toDouble()/100
        binding.etDisplay.setText(number.toString())
        isNewOP=true
    }

    fun btnCleanEvent(view: View) {
        binding.etDisplay.setText("0")
        isNewOP=true
    }

}