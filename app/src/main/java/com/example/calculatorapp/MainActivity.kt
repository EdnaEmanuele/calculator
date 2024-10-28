package com.example.calculatorapp

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.calculatorapp.databinding.ActivityMainBinding
import org.mariuszgromada.math.mxparser.Expression

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val calculation = binding.calculation

        binding.one.setOnClickListener {
            calculation.text = "${calculation.text}1"
        }

        binding.two.setOnClickListener {
            calculation.text = "${calculation.text}2"
        }

        binding.three.setOnClickListener {
            calculation.text = "${calculation.text}3"
        }

        binding.four.setOnClickListener {
            calculation.text = "${calculation.text}4"
        }

        binding.five.setOnClickListener {
            calculation.text = "${calculation.text}5"
        }

        binding.six.setOnClickListener {
            calculation.text = "${calculation.text}6"
        }

        binding.seven.setOnClickListener {
            calculation.text = "${calculation.text}7"
        }

        binding.eight.setOnClickListener {
            calculation.text = "${calculation.text}8"
        }

        binding.nine.setOnClickListener {
            calculation.text = "${calculation.text}9"
        }

        binding.zero.setOnClickListener {
            calculation.text = "${calculation.text}0"
        }

        binding.openingPerheses.setOnClickListener {
            calculation.text = "${calculation.text}("
        }

        binding.closingPerheses.setOnClickListener {
            calculation.text = "${calculation.text})"
        }

        binding.division.setOnClickListener {
            calculation.text = "${calculation.text}/"
        }

        binding.multiplication.setOnClickListener {
            calculation.text = "${calculation.text}*"
        }

        binding.subtraction.setOnClickListener {
            calculation.text = "${calculation.text}-"
        }

        binding.addition.setOnClickListener {
            calculation.text = "${calculation.text}+"
        }

        binding.point.setOnClickListener {
            calculation.text = "${calculation.text}."
        }

        binding.CE.setOnClickListener {
            calculation.text = " "
            binding.result.text = " "
        }

        binding.delete.setOnClickListener {
            calculation.text = calculation.text.dropLast(1)
        }

        binding.equals.setOnClickListener {
            val calculatedResults = Expression(calculation.text.toString()).calculate()

            if (calculatedResults.isNaN()){
                binding.result.text = "Error"
            } else {
                binding.result.text = calculatedResults.toString()
            }
        }
    }
}