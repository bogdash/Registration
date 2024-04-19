package com.bogdash.registration

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bogdash.registration.databinding.ActivityInputLastnameBinding

class InputLastnameActivity : AppCompatActivity() {
    private lateinit var lastname: String

    private lateinit var binding: ActivityInputLastnameBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityInputLastnameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.inputLastname) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonInputLastnameNext.setOnClickListener {
            getLastname()
            initIntent()
        }
    }

    private fun getLastname() {
        lastname = binding.editTextInputLastname.text.toString()
    }

    private fun initIntent() {
        val name = intent.getStringExtra(IntentKeys.NAME)
        val intent = Intent(this, InputAgeActivity::class.java)

        intent.putExtra(IntentKeys.NAME, name)
        intent.putExtra(IntentKeys.LASTNAME, lastname)
        startActivity(intent)
    }
}