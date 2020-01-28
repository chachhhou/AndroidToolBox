package fr.isen.suarez.androidtoolbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_information.*

class InformationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

       /* pictureButton.setOnClickListener {
            val galeryIntent = Intent (Intent.ACTION_PICK)//Gallery
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)//Camera
        }*/
    }
}
