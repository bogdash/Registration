package com.bogdash.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
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
        }

        binding.buttonInputAgeBack.setOnClickListener {
            finish()
        }

        binding.buttonInputAgeClose.setOnClickListener {
            navigateToRegistrationActivity()
        }
    }

    private fun getAge() {
        age = binding.editTextInputAge.text.toString()
        if (age.isNotEmpty()) {
            initIntent()
        } else {
            Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initIntent() {
        val name = intent.getStringExtra(Keys.NAME)
        val lastname = intent.getStringExtra(Keys.LASTNAME)

        val intent = Intent(this, WelcomeActivity::class.java)
        intent.putExtra(Keys.NAME, name)
        intent.putExtra(Keys.LASTNAME, lastname)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }

    private fun navigateToRegistrationActivity() {
        val intent = Intent(this, RegistrationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}