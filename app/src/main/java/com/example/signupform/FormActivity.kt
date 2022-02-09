package com.example.signupform

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class FormActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameField = findViewById<EditText>(R.id.nameField)
        val emailField = findViewById<EditText>(R.id.emailField)
        val passwordField = findViewById<EditText>(R.id.passwordField)
        val confirmField = findViewById<EditText>(R.id.confirmField)

        findViewById<Button>(R.id.saveButton).setOnClickListener {
            when { //checks that all fields have been filled out, and that passwords match
                nameField.text.isEmpty() ->
                    nameField.error = "Please enter name"
                emailField.text.isEmpty() ->
                    emailField.error = "Please enter email"
                passwordField.text.isEmpty() ->
                    passwordField.error = "Please enter password"
                confirmField.text.isEmpty() ->
                    confirmField.error = "Please confirm password"
                passwordField.text.toString() != confirmField.text.toString() ->
                    confirmField.error = "Error: Passwords do not match"
                else ->
                    Toast.makeText(this, "Welcome to SignUpForm", Toast.LENGTH_LONG).show()
            }
        }
    }
}