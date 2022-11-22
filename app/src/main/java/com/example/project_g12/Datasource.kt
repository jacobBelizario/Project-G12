package com.example.project_g12

class DataSource {

    private constructor() {}

    companion object {
        @Volatile
        private lateinit var instance: DataSource

        fun getInstance(): DataSource {
            synchronized(this) {
                if (!::instance.isInitialized) {
                    instance = DataSource()
                }
                return instance
            }
        }
    }
    //
    var lesson1 = Lesson(
        1,
        "https://www.youtube.com/watch?v=HfTXHrWMGVY&list=PLZlA0Gpn_vH-cEDOofOujFIknfZZpIk3a",
        "Introduction to the course",
        4,
        " In this lesson we will introduce you to the concept of web.this includes the languages of CSS HTML and Javascript")

    var lesson2 = Lesson(
        2,
        "https://www.youtube.com/watch?v=1HakS7KsbCk",
        "What is Javascript?",
        5,
        "This lesson talks about the language of the web which is javascript")

    var lesson3 = Lesson(
        3,
        "https://www.youtube.com/watch?v=IsG4Xd6LlsM",
        "Variables and conditionals",
        6,
        "This lesson talks about the different fundamental programming practices. tailored around javascript. Specifically variables and conditions")

    var lesson4 = Lesson(
        4,
        "https://www.youtube.com/watch?v=s9wW2PpJsmQ",
        "Loops",
        7,
        " This lesson talks about one of the most important programming fundamentals which is loops")


    var lessonList:ArrayList<Lesson> = arrayListOf<Lesson>(lesson1,lesson2,lesson3,lesson4)
    var user:User = User("", lessonList)
    var selectedLesson:Lesson? = null
    var switchStatus = false

    fun oldUser():Boolean{
        return user.userName.isNotEmpty()
    }

    fun createUser(userName: String) {
        this.user.userName = userName
    }

    fun reset(){
        user.userName = ""
    }
}