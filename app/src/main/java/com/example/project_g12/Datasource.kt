package com.example.project_g12

class Datasource {


    var currentUser: String?

    private constructor(){
        currentUser = null
    }

    companion object {
        @Volatile
        private lateinit var instance: Datasource

        fun getInstance(): Datasource {
            synchronized(this) {
                if (!::instance.isInitialized) {
                    instance = Datasource()
                }
                return instance
            }
        }
    }

}
