package com.example.project_g12
import java.io.Serializable
import java.util.concurrent.TimeUnit

class Lesson:Serializable {
    var name = ""
    var duration:Int = 0
    var isComplete = false
    var description = ""
    var position:Int = 0
    var note:String = ""
    var url:String = ""


    constructor(position:Int,url:String,name:String,duration: Int,description:String){
        this.position = position
        this.name = name
        this.duration = duration
        this.url = url
        this.description = description
    }
    fun fromMinutesToHHmm(): String {
        val hours = TimeUnit.MINUTES.toHours(this.duration.toLong())
        val remainMinutes = this.duration - TimeUnit.HOURS.toMinutes(hours)
        return String.format("%02d:%02d", hours, remainMinutes)
    }
}