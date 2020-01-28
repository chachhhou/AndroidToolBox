package fr.isen.suarez.androidtoolbox

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_life_cycle.*

class lifeCycle : AppCompatActivity(), OnFragmentListenerInteraction{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)

        val firstFragment = lifeCycleFragment()
        supportFragmentManager.beginTransaction().add(R.id.fragmentContainer, firstFragment).commit()

    }


    override fun onPause (){
        super.onPause()
        Log.d("thomas","Tache de fond")
    }

    override fun onDestroy(){
        super.onDestroy()
        Toast.makeText(this, "Cycle destroyed",Toast.LENGTH_LONG).show()
    }

    override fun swipeFragment() {
        val secondFragment = lifeCycleFragment2()
        supportFragmentManager.beginTransaction().replace(R.id.fragmentContainer, secondFragment).commit()
    }
}
