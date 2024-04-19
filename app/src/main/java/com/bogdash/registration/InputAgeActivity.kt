package com.bogdash.registration

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bogdash.registration.databinding.ActivityInputAgeBinding

class InputAgeActivity : AppCompatActivity() {
    private lateinit var age: String

    private lateinit var binding: ActivityInputAgeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityInputAgeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.inputName) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonInputAgeNext.setOnClickListener {
            getAge()
            initIntent()
        }
    }

    private fun getAge() {
        age = binding.editTextInputAge.text.toString()
    }

    private fun initIntent() {
        val intent = Intent(this, WelcomeActivity::class.java)
        startActivity(intent)
    }
}