package com.bogdash.registration

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bogdash.registration.databinding.ActivityInputNameBinding

class InputNameActivity : AppCompatActivity() {
    private lateinit var name: String

    private lateinit var binding: ActivityInputNameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityInputNameBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.inputName) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonInputNameNext.setOnClickListener {
            getName()
        }

        binding.buttonInputNameBack.setOnClickListener {
            finish()
        }

        binding.buttonInputNameClose.setOnClickListener {
            navigateToRegistrationActivity()
        }
    }

    private fun getName() {
        name = binding.editTextInputName.text.toString()
        if (name.isNotEmpty()) {
            initIntent()
        } else {
            Toast.makeText(this, "Поле не должно быть пустым", Toast.LENGTH_SHORT).show()
        }
    }

    private fun initIntent() {
        val intent = Intent(this, InputLastnameActivity::class.java)
        intent.putExtra(Keys.NAME, name)
        startActivity(intent)
    }

    private fun navigateToRegistrationActivity() {
        val intent = Intent(this, RegistrationActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}