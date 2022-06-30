package com.example.msftest

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import androidx.core.view.isVisible
import com.example.msftest.StringUtils.isFirstLetterCapital
import com.example.msftest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        handleSubmitButton()
        handleAnglePicker()
        handleNextButton()
    }

    private fun handleSubmitButton() {
        binding.submitButton.setOnClickListener {
            validateEnteredString()
        }
    }

    private fun validateEnteredString() {
        if (binding.enterStringEditText.text.toString().isFirstLetterCapital()) {
            binding.enterStringLayout.error = null
            hideKeyboard()
            binding.enterStringEditText.clearFocus()
            displayAngleLayout()
        } else {
            binding.enterStringLayout.error = getString(R.string.enter_string_error)
        }
    }

    private fun hideKeyboard() {
        currentFocus?.let { view ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(view.windowToken, 0)
        }
    }

    private fun displayAngleLayout() {
        binding.angleTextView.isVisible = true
        binding.anglePicker.isVisible = true
        binding.nextButton.isVisible = true
    }

    private fun handleAnglePicker() {
        binding.anglePicker.minValue = 0
        binding.anglePicker.maxValue = 360
    }

    private fun handleNextButton() {
        binding.nextButton.setOnClickListener {
            openImageActivity()
        }
    }

    private fun openImageActivity() {
        val rotation = binding.anglePicker.value.toFloat()
        startActivity(ImageActivity.getInstance(this, rotation))
    }
}