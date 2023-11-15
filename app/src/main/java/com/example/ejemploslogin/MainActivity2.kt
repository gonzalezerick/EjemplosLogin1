package com.example.ejemploslogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ejemploslogin.databinding.ActivityMainBinding
import com.google.firebase.auth.FirebaseAuth
import android.content.Intent

class MainActivity2 : AppCompatActivity() {
    // agregar viewBinding
    private lateinit var binding: ActivityMainBinding
    // importamos firebase auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar base auth
        auth = FirebaseAuth.getInstance()

        binding.btnlogin.setOnClickListener {
            val email = binding.etCorreo.text.toString()
            val password = binding.etPassword.text.toString()

            //Validar que los campos cuenten con datos
            if(email.isEmpty()) {
                binding.etCorreo.error = "Por favor ingrese un correo"
                return@setOnClickListener
            }
            if(password.isEmpty()) {
                binding.etPassword.error = "Por favor ingrese una contraseña"
                return@setOnClickListener
            }
            signIn(email,password)
        }
    }

    private fun signIn(email: String, password: String) {
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Toast.makeText(this, "Inicio correcto", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, PostLogin::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
                }
            }
    }
}
