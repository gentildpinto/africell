package me.gentilpinto.africell.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.AppCompatButton
import me.gentilpinto.africell.R

class LoginActivity : AppCompatActivity() {
    private lateinit var loginBtn: AppCompatButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initComponents()
        loginBtnClickEvent()
    }

    private fun initComponents() {
        loginBtn = findViewById(R.id.loginBtn)
    }

    private fun loginBtnClickEvent() {
        loginBtn.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }
}