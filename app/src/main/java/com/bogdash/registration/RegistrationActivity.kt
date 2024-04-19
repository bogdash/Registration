package com.bogdash.registration

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.bogdash.registration.databinding.ActivityRegistrationBinding

class RegistrationActivity : AppCompatActivity() {
    private lateinit var binding: ActivityRegistrationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.registration) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.buttonStartRegistration.setOnClickListener {
            val intent = Intent(this, InputNameActivity::class.java)
            startActivity(intent)
        }

        checkUserRegistration()
    }

    private fun checkUserRegistration() {
        val sharedPreferences = this.getSharedPreferences(Keys.USER_PREFS, Context.MODE_PRIVATE)
        val isRegistered = sharedPreferences.getBoolean(Keys.IS_REGISTERED, false)
        val name = sharedPreferences.getString(Keys.NAME, "")
        val lastname = sharedPreferences.getString(Keys.LASTNAME, "")

        if (isRegistered) {
            initIntent(name, lastname)
        }
    }

    private fun initIntent(name: String?, lastname: String?) {
        val intent = Intent(this, WelcomeActivity::class.java)
        intent.putExtra(Keys.NAME, name)
        intent.putExtra(Keys.LASTNAME, lastname)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
}