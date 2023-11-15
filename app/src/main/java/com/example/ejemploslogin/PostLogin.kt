package com.example.ejemploslogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ejemploslogin.databinding.ActivityPostLoginBinding
import com.google.firebase.auth.FirebaseAuth

class PostLogin : AppCompatActivity() {
    // agregar viewBinding
    private lateinit var binding: ActivityPostLoginBinding
    // importamos firebase auth
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPostLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar base auth
        auth = FirebaseAuth.getInstance()

        binding.btncerrar.setOnClickListener {
            auth.signOut()
            finish()
        }
    }
}
