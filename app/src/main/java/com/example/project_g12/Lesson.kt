package com.example.project_g12
import java.io.Serializable
import java.util.concurrent.TimeUnit

class Lesson:Serializable {
    var name = ""
    var duration:Int = 0
    var isComplete = false


    constructor(name:String,duration: Int){
        this.name = name
        this.duration = duration
    }
    fun fromMinutesToHHmm(): String {
        val hours = TimeUnit.MINUTES.toHours(this.duration.toLong())
        val remainMinutes = this.duration - TimeUnit.HOURS.toMinutes(hours)
        return String.format("%02d:%02d", hours, remainMinutes)
    }
}