package com.example.project_g12
import java.io.Serializable

class Lesson:Serializable {
    var name = ""
    var duration:Int = 0
    var isComplete = false

    constructor(name:String,duration: Int){
        this.name = name
        this.duration = duration
    }
}