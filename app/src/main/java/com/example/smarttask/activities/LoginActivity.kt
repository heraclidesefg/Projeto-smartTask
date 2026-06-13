package com.example.smarttask.activities // Ajuste para o seu pacote real

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.smarttask.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // 1. Verificar se o usuário já logou anteriormente
        val sharedPreferences = getSharedPreferences("AppPrefs", Context.MODE_PRIVATE)
        val estaLogado = sharedPreferences.getBoolean("logado", false)

        if (estaLogado) {
            irParaMain()
            return // Para a execução do onCreate aqui
        }

        setContentView(R.layout.activity_login)

        val edtEmail = findViewById<EditText>(R.id.edtEmail)
        val edtSenha = findViewById<EditText>(R.id.edtSenha)
        val btnLogin = findViewById<Button>(R.id.btnLogin)

        btnLogin.setOnClickListener {
            val email = edtEmail.text.toString().trim()
            val senha = edtSenha.text.toString().trim()

            // Usuário e senha fixos apenas para teste local
            if (email == "professor@teste.com" && senha == "12345") {

                // Salva que o usuário está logado com sucesso
                val editor = sharedPreferences.edit()
                editor.putBoolean("logado", true)
                editor.apply()

                irParaMain()
            } else {
                Toast.makeText(this, "E-mail ou senha incorretos!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun irParaMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish() // Fecha a LoginActivity para não voltar nela ao clicar em "Voltar"
    }
}