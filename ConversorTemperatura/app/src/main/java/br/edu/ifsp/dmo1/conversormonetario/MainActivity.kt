package br.edu.ifsp.conversormonetario

import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.EditText
import java.lang.NumberFormatException
import android.os.Bundle
import android.os.PersistableBundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.edu.ifsp.dmo1.conversormonetario.R

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val DOLLAR_VALUE = 5.50
    private lateinit var inputEditText: EditText
    private lateinit var toDollarButton: Button
    private lateinit var toRealButton: Button
    private lateinit var outputTextView: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findById()
        configClickListener()
    }

    override fun onClick(v: View?) {
        if (v==toDollarButton){
            dollarConversion()
        } else if (v==toRealButton){
            realConversion()
        }
    }

    private fun findById(){
        inputEditText = findViewById(R.id.edittext_value)
        toDollarButton = findViewById(R.id.button_convert_to_dollar)
        toRealButton = findViewById(R.id.button_convert_to_real)
        outputTextView = findViewById(R.id.textview_output)
    }

    private fun configClickListener(){
        toDollarButton.setOnClickListener(this)
        toRealButton.setOnClickListener(this)
    }

    private fun getValue(): Double{
        return try {
            inputEditText.text.toString().toDouble()
        } catch (e: NumberFormatException) {
            0.0
        }
    }

    private fun dollarConversion(){
        var value = getValue()
        value = value / DOLLAR_VALUE
        outputTextView.text = String.format("U\$ %.2f", value)
    }

    private fun realConversion(){
        var value = getValue()
        value = value * DOLLAR_VALUE
        outputTextView.text = String.format("U\$ %.2f", value)
    }
}