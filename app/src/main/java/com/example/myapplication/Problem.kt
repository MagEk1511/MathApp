package com.example.myapplication

import kotlin.random.Random

class Problem {

    var result: Int = 0

    fun getNoiseResult(): Int{
        return result + getRandom(-4, 4)
    }

    fun getRandom(min: Int, max: Int): Int {
        return (Math.random() * (max - min) + min).toInt()
    }


    private fun getRandomSign(): Char {
        var rand = getRandom(1, 5)
        when(rand){
            1 -> return '+'
            2 -> return '-'
            3 -> return '*'
            4 -> return '/'
        }
        return ' '
    }

    fun getProblem(): String {
        val a = getRandom(-50, 50)
        val b = getRandom(0, 50)
        val sign = getRandomSign()
        when(sign){
            '+' -> result = a + b
            '-' -> result = a - b
            '*' -> result = a * b
            '/' -> result = a / b
        }
        return "$a $sign $b ="
    }
}