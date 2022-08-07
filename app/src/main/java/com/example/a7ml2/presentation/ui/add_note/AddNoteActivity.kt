package com.example.a7ml2.presentation.ui.add_note

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a7ml2.databinding.ActivityAddNoteBinding
import com.example.a7ml2.domain.model.Note
import com.example.a7ml2.extensions.showToast

class AddNoteActivity : AppCompatActivity() {

    private lateinit var binding: ActivityAddNoteBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initClickers()
    }
    private fun initClickers() {
        binding.btnEnter.setOnClickListener {
            val text = binding.etTitle.text.toString()
            val description = binding.etDescription.text.toString()
            when {
                text.isEmpty() -> {
                    showToast("Enter title")
                }
                description.isEmpty() -> {
                    showToast("Enter description")
                }
                else -> {
                    Intent().apply {
                        putExtra(noteKey, Note(text,description))
                        setResult(RESULT_OK, this)
                        finish()
                    }
                }
            }
        }
    }
    companion object {
        const val noteKey = "tKey"
    }
}