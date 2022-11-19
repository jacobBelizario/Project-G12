package com.example.project_g12

class DataSource {
    var userName:String=""
    var courseList:MutableList<String> = mutableListOf<String>()
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
}