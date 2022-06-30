package com.example.msftest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.msftest.databinding.ActivityImageBinding

class ImageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityImageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        displayImage(intent.getFloatExtra(ROTATION_EXTRA, 0f))
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }

    private fun displayImage(rotation: Float) {
        binding.rotatedImageView.rotation = rotation
    }

    companion object {
        private const val ROTATION_EXTRA = "rotation_extra"

        fun getInstance(context: Context, rotation: Float) =
            Intent(context, ImageActivity::class.java).apply {
                putExtra(ROTATION_EXTRA, rotation)
            }
    }
}