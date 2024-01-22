package com.example.registration

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?): SQLiteOpenHelper(context, "app", factory, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val querry = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, password TEXT)"
        db?.execSQL(querry)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db?.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser (user: User){
        val value = ContentValues()
        value.put("login", user.login)
        value.put("email", user.email)
        value.put("password", user.password)

        val db = this.writableDatabase
        db.insert("users", null, value)
        db.close()
    }
    fun getUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase
        val result =
            db.rawQuery("SELECT * FROM users WHERE login = '$login' AND password = '$pass'", null)
        return result.moveToFirst()
    }
}