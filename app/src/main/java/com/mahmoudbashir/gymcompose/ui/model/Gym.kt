package com.mahmoudbashir.gymcompose.ui.model


val gList = listOf<Gym>(
    Gym(1,"Air Gym","10 st Nasr City"),
    Gym(2,"Air Gym","10 st Nasr City"),
    Gym(3,"Air Gym","10 st Nasr City"),
    Gym(4,"Air Gym","10 st Nasr City"),
    Gym(5,"Air Gym","10 st Nasr City"),
    Gym(6,"Air Gym","10 st Nasr City"),
    Gym(7,"Air Gym","10 st Nasr City"),
    Gym(8,"Air Gym","10 st Nasr City"),
    Gym(9,"Air Gym","10 st Nasr City"),
    Gym(10,"Air Gym","10 st Nasr City"),
    Gym(11,"Air Gym","10 st Nasr City"),
    Gym(12,"Air Gym","10 st Nasr City"),
    Gym(13,"Air Gym","10 st Nasr City"),
    Gym(14,"Air Gym","10 st Nasr City"),
)

data class Gym(val id:Int,val name:String,val place:String,var isFavourite:Boolean=false)

