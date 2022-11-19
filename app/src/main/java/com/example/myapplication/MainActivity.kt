package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding

public class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private final var problem = Problem()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        generateProblem()
        println(problem.result)
        val listener = MyClickListener()
        binding.button.setOnClickListener(listener)
        binding.solution1.setOnClickListener(listener)
        binding.solution2.setOnClickListener(listener)
        binding.solution3.setOnClickListener(listener)
    }

    fun generateProblem() {
        val position = problem.getRandom(1, 3)
        binding.problem.text = problem.getProblem()
        when (position) {
            1 -> {
                binding.solution1.text = problem.result.toString()
                binding.solution2.text = problem.getNoiseResult().toString()
                binding.solution3.text = problem.getNoiseResult().toString()
            }
            2 -> {
                binding.solution1.text = problem.getNoiseResult().toString()
                binding.solution2.text = problem.result.toString()
                binding.solution3.text = problem.getNoiseResult().toString()
            }
            3 -> {
                binding.solution1.text = problem.getNoiseResult().toString()
                binding.solution2.text = problem.getNoiseResult().toString()
                binding.solution3.text = problem.result.toString()
            }


        }
    }

    class MyClickListener : View.OnClickListener  {
        override public fun onClick(view: View) {
            println(MainActivity().problem.result.toString())
            when (view.id) {
                R.id.button -> MainActivity().generateProblem()
                R.id.solution1, R.id.solution2, R.id.solution3  -> {
                    val text = (view as TextView).text.toString()
                    val res = MainActivity().problem.result.toString()
                    if (text == res) {
                        view.setBackgroundResource(R.drawable.button_style_correct)
                    } else {
                        view.setBackgroundResource(R.drawable.button_style_incorrect)
                    }
                }
            }
        }

    }

}