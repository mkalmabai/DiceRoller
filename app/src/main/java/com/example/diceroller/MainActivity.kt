package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.button)
        rollButton.setOnClickListener {
            rollDice()
            val toast = Toast.makeText(this,"Dice rolled", Toast.LENGTH_SHORT)
//            toast.show()


//
//            val resultTextView:TextView  = findViewById(R.id.TextView)
//            resultTextView.text = "6"

        }
    }

    class Dice(private val numSides: Int) {
        fun roll(): Int {
            return (1..numSides).random()
        }
    }

    private fun rollDice() {



        val dicearr = arrayOf<Int>(R.id.imageView3, R.id.imageView4)

        for (x in dicearr) {
            val diceImage: ImageView = findViewById(x)

            val dice = Dice(6)
            val diceRoll = dice.roll()

            val drawableResource = when (diceRoll) {
                1 -> R.drawable.d1
                2 -> R.drawable.d2
                3 -> R.drawable.d3
                4 -> R.drawable.d4
                5 -> R.drawable.d5
                else -> R.drawable.d6
            }
            diceImage.setImageResource(drawableResource)
            diceImage.contentDescription = diceRoll.toString()


        }
    }
}






