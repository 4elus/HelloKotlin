package itfun.school.hellokotlin

import android.util.Log

object Person {
    fun copy(user: User) {
        val copyUser = user
        Log.v("Info", "${copyUser.name}, ${copyUser.age}")
    }
}