package fr.isen.suarez.androidtoolbox

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast

class lifeCycle : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_life_cycle)
    }


    override fun onPause (){
        super.onPause()
        Log.d("thomas","Tache de fond")
    }

    override fun onDestroy(){
        super.onDestroy()
        Toast.makeText(this, "Cycle destroyed",Toast.LENGTH_LONG).show()
    }
}
