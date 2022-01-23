package com.example.loginapp

class User{
    var id : Int = 0
    var name : String = ""
    var email : String = ""
    var phone : String = ""
    var password : String = ""

  public constructor(name:String,email:String,phone:String,password:String){
        this.name = name
        this.email = email
        this.phone = phone
        this.password = password
    }
}