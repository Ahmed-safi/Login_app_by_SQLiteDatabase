package com.example.loginapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sign.*

class SignActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign)


        Login_bt.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
            val context = this
            btn_Sign.setOnClickListener {
                if(edt_name.text.toString().length > 0 && edt_email.text.toString().length > 0 && edt_phone.text.toString().length > 0 && edt_pass.text.toString().length > 0) {
                    var user = User(edt_name.text.toString(),edt_email.text.toString(),edt_phone.text.toString(),edt_pass.text.toString())
                    var db = DBHelper(this)
                    db.insertData(user)
                }else{
                    Toast.makeText(context, "Please Fill All Data's", Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
