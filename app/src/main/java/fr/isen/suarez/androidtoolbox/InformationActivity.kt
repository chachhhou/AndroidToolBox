import android.R.attr
import android.R.attr.bitmap
import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.MediaStore
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import fr.isen.suarez.androidtoolbox.R
import kotlinx.android.synthetic.main.activity_information.*
import java.io.File
import java.security.acl.Permission
import java.util.jar.Manifest


class InformationActivity : AppCompatActivity() {

    companion object {
        val pictureRequestCode = 1
        val contactPermissionRequestCode = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_information)

        pictureButton.setOnClickListener {
            onChangePhoto()
        }

        requestPermission(android.Manifest.permission.READ_CONTACTS, contactPermissionRequestCode) {
            readContacts()
        }
    }

    fun onChangePhoto() {
        val galleryIntent = Intent(Intent.ACTION_PICK)
        galleryIntent.type = "image/*"

        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)

        val intentChooser = Intent.createChooser(galleryIntent, "Choose your picture library")
        intentChooser.putExtra(Intent.EXTRA_INITIAL_INTENTS, arrayOf(cameraIntent))
        startActivityForResult(intentChooser, InformationActivity.pictureRequestCode)
    }

    fun readContacts() {
        val contacts = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)
        Log.d("contacts", "${contacts}")
    }

    fun requestPermission(permissionToRequest: String, requestCode: Int, handler: ()-> Unit) {
        if(ContextCompat.checkSelfPermission(this, permissionToRequest) != PackageManager.PERMISSION_GRANTED) {
            if(ActivityCompat.shouldShowRequestPermissionRationale(this, permissionToRequest)) {
                //display toast
            } else {
                ActivityCompat.requestPermissions(this, arrayOf(permissionToRequest), requestCode)
            }
        } else {
            handler()
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if(grantResults.isNotEmpty()) {
            if (requestCode == InformationActivity.contactPermissionRequestCode &&
                grantResults[0] == PackageManager.PERMISSION_GRANTED
            ) {
                readContacts()
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == InformationActivity.pictureRequestCode &&
            resultCode == Activity.RESULT_OK) {
            if(data?.data != null) { // Gallery
                pictureButton.setImageURI(data?.data)
            } else { // Camera
                val bitmap = data?.extras?.get("data") as? Bitmap
                bitmap?.let {
                    pictureButton.setImageBitmap(it)
                }
            }
        }
    }
}