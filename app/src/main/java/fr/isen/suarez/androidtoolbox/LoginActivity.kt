package fr.isen.suarez.androidtoolbox

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import org.intellij.lang.annotations.Identifier

class LoginActivity : AppCompatActivity() {

   

    var userPref: SharedPreferences? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        userPref = getSharedPreferences(Constants.UserPreferencesName, Context.MODE_PRIVATE)
        checkPreferences()
        validateButton.setOnClickListener {
           /*Toast.makeText(this, "coucou ${userName.text}",Toast.LENGTH_LONG).show()*/
            doLogin()
            
        }
    }

    fun doLogin(){
        if (canLog(userName.text.toString(), passwordEditText.text.toString())){
            saveUser(userName.text.toString(),passwordEditText.text.toString())
            val intent = Intent(this, HomeActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TOP
            startActivity(intent)
        }
    }

    fun canLog(identifier: String, password: String): Boolean {
        return identifier == Constants.goodIdentifier && password == Constants.goodPassword
    }

    fun saveUser(identifier: String, password: String){
        val editor = userPref?.edit()
        editor?.putString(Constants.kIdentifier, identifier)
        editor?.putString(Constants.kPassword, password)
        editor?.commit()
    }

    fun checkPreferences(){
        val identifier = userPref?.getString(Constants.kIdentifier, null) ?:""
        val password = userPref?.getString(Constants.kPassword, null) ?:""
        userName.setText(identifier)
        passwordEditText.setText(password)
        doLogin()
    }
}
