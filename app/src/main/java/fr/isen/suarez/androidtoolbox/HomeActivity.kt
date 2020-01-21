package fr.isen.suarez.androidtoolbox

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
    }


    fun doClick(){

            val intent = Intent(this, lifeCycle::class.java)
            startActivity(intent)
    }


}
