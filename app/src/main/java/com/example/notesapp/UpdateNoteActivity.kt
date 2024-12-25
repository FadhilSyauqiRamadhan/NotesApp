package com.example.notesapp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.notesapp.databinding.ActivityUpdateNoteBinding
import com.example.notesapp.dbhelper.NoteDatabaseHelper
import com.example.notesapp.model.Note

class UpdateNoteActivity : AppCompatActivity() {
    private lateinit var binding : ActivityUpdateNoteBinding
    private lateinit var db : NoteDatabaseHelper

    private var noteId : Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NoteDatabaseHelper(this)
        noteId = intent.getIntExtra("note_id", -1)
        if (noteId == -1){
            finish()
            return
        }
        val note = db.getNoteByID(noteId)
        binding.etEditJudul.setText(note.title)
        binding.etEditCatatan.setText(note.content)

        binding.btnUpdateNote.setOnClickListener(){
            val newTitle = binding.etEditJudul.text.toString() //setelah apa yg didapatkan
            val newContent = binding.etEditCatatan.text.toString()

            val updateNote = Note(noteId, newTitle, newContent)
            db.updateNote(updateNote)
            finish()
            Toast.makeText(this,"Update Berhasil", Toast.LENGTH_SHORT).show()
        }
    }
}