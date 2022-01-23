package com.example.loginapp

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.widget.Toast

val DATABASE_NAME = "AbdDB"
val TABLED_NAME = "User"
val COL_NAME = "name"
val COL_EMAIL = "email"
val COL_PHONE = "phone"
val COL_PASSWORD = "password"

class DBHelper(var context: Context):SQLiteOpenHelper(context, DATABASE_NAME,null,1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val createTable = "CREATE TABLE " + TABLED_NAME + " (" +
                COL_NAME + " VARCHAR(256) PRIMARY KEY ," +
                COL_EMAIL + " VARCHAR(256) ," +
                COL_PHONE + " VARCHAR(256)," +
                COL_PASSWORD + " VARCHAR(256))"
        db?.execSQL(createTable)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun insertData(user: User) {
        val db = this.writableDatabase
        var cv = ContentValues()
        cv.put(COL_NAME, user.name)
        cv.put(COL_EMAIL, user.email)
        cv.put(COL_PHONE, user.phone)
        cv.put(COL_PASSWORD, user.password)
        var result = db.insert(TABLED_NAME, null, cv)
        if (result == -1.toLong())
            Toast.makeText(context, "Failed", Toast.LENGTH_SHORT).show()
        else
            Toast.makeText(context, "Success", Toast.LENGTH_SHORT).show()

    }
    fun allData (name:String): User {
       val ad = this.readableDatabase
       var abd = ad.rawQuery("select * from User where name='$name'",null)
        abd.moveToFirst()
        val user = User(
            abd.getString(abd.getColumnIndex("name")),
            abd.getString(abd.getColumnIndex("email")),
            abd.getString(abd.getColumnIndex("phone")),
            abd.getString(abd.getColumnIndex("password"))
            )
        abd.close()
       return user

//    fun userPresent(name:String,password: String): Boolean{
//        val db = writableDatabase
//        val qurey ="select * from User where name='$name' and  password = '$password'"
//        val cursor = db.rawQuery(qurey,null)
//        if (cursor.count<=0){
//            cursor.close()
//            return false
//        }
//        cursor.close()
//        return true

    }
}