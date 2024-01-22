package com.example.registration

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_auth)

        val userLogin: EditText = findViewById (R.id.userLog_auth)
        val userPass: EditText = findViewById (R.id.userPass_auth)
        val userButton: Button = findViewById (R.id.buttonAuth)
        val linkToreg: TextView = findViewById(R.id.link_to_reg)

        linkToreg.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        userButton.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (login == "" || pass == "") {
                Toast.makeText(this, "Не все поля заполнены", Toast.LENGTH_LONG).show()
            }else {
                val db = DbHelper(this,null)
                val isAuth = db.getUser(login,pass)

                if (isAuth){
                    Toast.makeText(this,"Добро пожаловать, $login!", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this, ItemActivity::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this,"Неверно введен логин или пароль, попробуйте еще раз", Toast.LENGTH_LONG).show()
            }
        }
    }
}