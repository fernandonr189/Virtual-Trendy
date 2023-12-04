package com.example.virtualtrendy

class User(var clientId : Int, var userName: String, var address: String, var userEmail : String, var userPhone: String, var password: String) {

    override fun toString() : String {
        val userString : String =   clientId.toString() + "\n" +
                                    userName + "\n" +
                                    address + "\n" +
                                    userEmail + "\n" +
                                    userPhone + "\n" +
                                    password + "\n" +
                                    "\\"
        return userString
    }

    public fun fromString(data : String) {
        val userData = data.split("\n")
        clientId = userData[0].toInt()
        userName = userData[1]
        address = userData[2]
        userEmail = userData[3]
        userPhone = userData[4]
        password = userData[5]
    }
}