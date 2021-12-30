package itfun.school.hellokotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val listUsers = listOf<User>(
            User("Alex", 23),
            User("Sam", 22),
            User("James", 28)
        )

        findViewById<Button>(R.id.btn_msg).setOnClickListener(View.OnClickListener {
            showMessage("Hello Kotlin!")
        })

        findViewById<Button>(R.id.btn_fin_min_user).setOnClickListener(View.OnClickListener {
            val user = findMinAgeUser(listUsers)

            Toast.makeText(this, "${user.name}, ${user.age}", Toast.LENGTH_SHORT).show()
        })

        findViewById<Button>(R.id.btn_copy).setOnClickListener(View.OnClickListener {
            Person.copy(listUsers[2])
        })

        findViewById<Button>(R.id.btn_cycle).setOnClickListener(View.OnClickListener {
            infoUsers(listUsers)
        })
    }

    fun showMessage(text : String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    fun findMinAgeUser(users: List<User>) : User{
        var min = users[0]
        for (user in users){
            if (user.age < min.age)
                min = user
        }

        return min
    }

    fun infoUsers(users: List<User>){
        for (user in users)
            Log.v("InfoUsers", "${user.name}, ${user.age}")
    }
}
