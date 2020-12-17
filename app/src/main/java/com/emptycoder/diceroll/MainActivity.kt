package com.emptycoder.diceroll

import android.content.ComponentCallbacks2
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.motion.widget.TransitionBuilder.validate
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val model = ViewModelProvider(this).get(startPointViewModel::class.java)

        var btn: Button = findViewById(R.id.btnDice)
        var input: EditText = findViewById(R.id.bet)
        var score: TextView = findViewById(R.id.score)
        score.setText(model.getPoint().toString())
        image.setImageResource(model.getImage())

        btn.setOnClickListener {


                model.setAmount(input.text.toString().toInt())

                if (input.text.isEmpty()) {
                    input.error = "Please enter bet amount"
                } else {
                    if (model.getamount() <= model.getPoint() && model.getamount() >= 0) {
                        model.setDice(1 + (Math.random() * 6).toInt())
                        when (model.getDice()) {
                            6 -> {
                                model.setPoint(model.getamount() * 3)
                                score.setText(model.getPoint().toString())
                                model.setImage(R.drawable.six)
                                image.setImageResource(model.getImage())
                            }
                            5 -> {
                                model.setPoint(model.getamount() * 2)
                                score.setText(model.getPoint().toString())
                                model.setImage(R.drawable.five)
                                image.setImageResource(model.getImage())
                            }
                            4 -> {
                                model.setPoint(model.getamount() * 2)
                                score.setText(model.getPoint().toString())
                                model.setImage(R.drawable.four)
                                image.setImageResource(model.getImage())
                            }
                            3 -> {
                                model.setPoint(model.getamount())
                                score.setText(model.getPoint().toString())
                                model.setImage(R.drawable.three)
                                image.setImageResource(model.getImage())
                            }
                            2 -> {
                                model.setPointN(model.getamount())
                                score.setText(model.getPoint().toString())
                                model.setImage(R.drawable.two)
                                image.setImageResource(model.getImage())
                            }
                            1 -> {
                                model.setPointEnd()
                                score.setText(model.getPoint().toString())
                                model.setImage(R.drawable.one)
                                image.setImageResource(model.getImage())
                                Toast.makeText(this, "Game Over", Toast.LENGTH_LONG).show()
                            }
                        }
                        input.setText("")
                        if (model.getPoint() == 0) {
                            Toast.makeText(this, "Game Over!", Toast.LENGTH_LONG).show()
                        }

                    } else {
                        Toast.makeText(this, "Error input", Toast.LENGTH_LONG).show()
                        bet.setText("")
                        bet.requestFocus()
                    }
                }}

        }
    }



