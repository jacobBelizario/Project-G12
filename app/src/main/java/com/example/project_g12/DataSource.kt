package com.example.project_g12

class DataSource {
    lateinit var user:User

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
    var lesson1 = Lesson("Introduction to the course",12)
    var lesson2 = Lesson("What is Javascript?",30)
    var lesson3 = Lesson("Variables and conditionals",80)
    var lesson4 = Lesson("Loops",38)
    var lessonList:ArrayList<Lesson> = arrayListOf<Lesson>(lesson1,lesson2,lesson3,lesson4)

    // for testing purpose only
    var testUser = User("Jacob", lessonList)

    fun checkUser():Boolean{
        if(this.user == null) {
            return false
        }
        return true
    }

    fun createUser(user:User) {
        this.user = user
        this.user.lessonList = lessonList
    }
}