package com.example.thiru

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.thiru.databinding.ActivityLoginBinding
import com.example.thiru.databinding.ActivityMainBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var loginBinding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        loginBinding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(loginBinding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loginBinding.passwordToggle.setOnClickListener {
            if (loginBinding.passwordValue.transformationMethod == PasswordTransformationMethod.getInstance()){
                loginBinding.passwordValue.transformationMethod = HideReturnsTransformationMethod.getInstance()
                loginBinding.passwordToggle.setImageResource(R.drawable.eye);
            }
            else{
                loginBinding.passwordValue.transformationMethod = PasswordTransformationMethod.getInstance();
                loginBinding.passwordToggle.setImageResource(R.drawable.eye_off);
            }
        }

        loginBinding.signInBtn.setOnClickListener{
            startActivity(Intent(this@LoginActivity, UserProfileEditPage::class.java))
        }
    }
}