package com.emptycoder.diceroll

import androidx.lifecycle.ViewModel

class startPointViewModel: ViewModel() {
    private var startPoint : Int = 100
    private var amount: Int =0
    private var dice: Int = 1
    private var src: Int = R.drawable.one

    fun getPoint() : Int = startPoint
    fun setPoint(value : Int){
        startPoint+= value
    }
    fun setPointN(value : Int){
        startPoint-= value
    }
    fun setPointEnd(){
        startPoint =0
    }

    fun getamount(): Int = amount
    fun setAmount(value: Int){
        amount = value
    }

    fun getDice(): Int = dice
    fun setDice(value: Int){
        dice = value
    }

    fun setImage(image: Int){
        src = image
    }
    fun getImage(): Int = src

    }
