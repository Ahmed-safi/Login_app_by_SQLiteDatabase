package com.example.loginapp

import android.content.Intent
import android.os.AsyncTask
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    val context = this
    var db: DBHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Sign_bt.setOnClickListener {
            val intent = Intent(this, SignActivity::class.java)
            startActivity(intent)
        }


        btn_login.setOnClickListener {
            ProgressAsyncTask()

        }

        }


    val user_name = R.id.log_name
    val user_pass = R.id.log_pass
    inner class ProgressAsyncTask : AsyncTask<String?, String?, User>() {

        override fun onPreExecute() {

            db = DBHelper(context)
            super.onPreExecute()
        }

        override fun doInBackground(vararg params: String?): User? {

            var user = db?.allData(params.toString())
            val name2 = user?.name
            val pass2 = user?.password
            var a = params.equals(name2) && params.equals(pass2)
            if (a == true) {
                Toast.makeText(context, "sucsses", Toast.LENGTH_SHORT).show()

            }else{
                if (params != null) {
                    Toast.makeText(context, "error", Toast.LENGTH_SHORT).show()
                }
            }
            return user

        }

        override fun onProgressUpdate(vararg values: String?) {
            Toast.makeText(context, "sucsses", Toast.LENGTH_SHORT).show()
            super.onProgressUpdate(*values)
        }

        override fun onPostExecute(result: User?) {
            Toast.makeText(context, "sucsses", Toast.LENGTH_SHORT).show()
            super.onPostExecute(result)
        }

        override fun onCancelled() {
            super.onCancelled()
        }


    }
}

