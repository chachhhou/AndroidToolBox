package fr.isen.suarez.androidtoolbox

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.activity_login.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        cycleButton.setOnClickListener {
            /*Toast.makeText(this, "coucou ${userName.text}",Toast.LENGTH_LONG).show()*/
            doClick()


        }

        saveButton.setOnClickListener{
            val intent = Intent(this, SaveActivity::class.java)
            startActivity(intent)
        }

        buttonLogOut.setOnClickListener {
            val userPref = getSharedPreferences(Constants.UserPreferencesName, Context.MODE_PRIVATE)
            val editor = userPref.edit()
            editor.clear()
            editor.apply()
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
            finish()

        }
    }


    fun doClick(){

            val intent = Intent(this, lifeCycle::class.java)
            startActivity(intent)
    }


}
