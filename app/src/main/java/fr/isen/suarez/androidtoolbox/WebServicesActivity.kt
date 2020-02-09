package fr.isen.suarez.androidtoolbox
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import fr.isen.suarez.androidtoolbox.Models.RandomUserResult
import com.google.gson.Gson
import fr.isen.suarez.androidtoolbox.Models.UserModel
import kotlinx.android.synthetic.main.activity_web_services.*

/*class WebServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_services)

        val userApiUrl = "https://randomuser.me/api/?results=20"
        val queue = Volley.newRequestQueue(this)

        val req = StringRequest(Request.Method.GET, userApiUrl, Response.Listener {

            val gson = Gson()
            val result = gson.fromJson(it, RandomUserResult::class.java)



            /*userRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
            userRecyclerView.adapter = UsersAdapter(result.results)*/

            result.results?.let {
                Log.d("volley", it[0].gender)

            }


        }, Response.ErrorListener {
            Log.d("volley", it.toString())
        })

        queue.add(req)
    }
}*/

class WebServicesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_services)
        getUsers()
    }

    fun getUsers() {

        // Instantiate the RequestQueue.
        val queue = Volley.newRequestQueue(this)
        val url = "https://randomuser.me/api/?results=20"



        // Request a string response from the provided URL.
        val stringReq =
            StringRequest(Request.Method.GET, url, Response.Listener<String> { response ->

                val gson = Gson()
                val result = gson.fromJson(response, RandomUserResult::class.java)
                var personList = ArrayList<UserModel>()

                result.results?.let {
                    it.forEach{
                        var person = UserModel()
                        person.gender = it.gender
                        person.fName = it.name?.first
                        person.lName = it.name?.last
                        personList.add(person)


                    }
                }
                userRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
                userRecyclerView.adapter = UsersAdapter(personList)

            },
                Response.ErrorListener {
                    Log.d("volley", it.toString())
                })

        queue.add(stringReq)
    }



    }


