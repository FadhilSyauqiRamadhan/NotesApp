package com.example.notesapp

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesapp.databinding.ActivityDetailPageBinding

class DetailPageActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Mendapatkan data dari Intent
        val title = intent.getStringExtra("title")
        val content = intent.getStringExtra("content")

        // Menampilkan data di layout
        binding.tvDetailJudul.text = title ?: "Tidak ada judul"
        binding.tvIsiNotes.text = content ?: "Tidak ada isi catatan"

        // Menerapkan WindowInsets pada root layout (ConstraintLayout dengan ID "main")
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}