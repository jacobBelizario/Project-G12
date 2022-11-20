package com.example.project_g12
import java.io.Serializable
class User:Serializable {
    var userName = ""
    var lessonList:ArrayList<Lesson> = arrayListOf()

    constructor(userName: String,lessonList:ArrayList<Lesson>) {
        this.userName = userName
        // initialize user with predefined classes
        this.lessonList = lessonList
    }
}