package com.example.a7ml2.presentation.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.a7ml2.core.Resource
import com.example.a7ml2.core.UIState
import com.example.a7ml2.domain.model.Note
import com.example.a7ml2.domain.use_case.AddNoteUseCase
import com.example.a7ml2.domain.use_case.DeleteNoteUseCase
import com.example.a7ml2.domain.use_case.GetAllNotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllNotesUseCase: GetAllNotesUseCase,
    private val addNoteUseCase: AddNoteUseCase,
    private val deleteNoteUseCase: DeleteNoteUseCase
) : ViewModel() {

    private val _notesState = MutableStateFlow<UIState<List<Note>>>(UIState.Loading())
    val noteState = _notesState.asStateFlow()

    private val _addNotesState = MutableStateFlow<UIState<Boolean>>(UIState.Loading())
    val addNotesState = _addNotesState.asStateFlow()

    private val _deleteNotesState = MutableStateFlow<UIState<Boolean>>(UIState.Loading())
    val deleteNotesState = _deleteNotesState.asStateFlow()

    fun addNote(note: Note) {
        viewModelScope.launch(Dispatchers.IO) {
            addNoteUseCase.addNote(note).collect {
                when(it){
                    is Resource.Error -> {
                        _addNotesState.value = UIState.Error(it.message?: "Error")
                    }
                    is Resource.Loading -> {
                        _addNotesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _addNotesState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }

    fun deleteNote() {
        viewModelScope.launch {
            deleteNoteUseCase.deleteNote().collect {
                when(it) {
                    is Resource.Error -> {
                        _deleteNotesState.value = UIState.Error(it.message?: "Error")
                    }
                    is Resource.Loading -> {
                        _deleteNotesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _deleteNotesState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }

    }

    fun getAllNotes() {
        viewModelScope.launch(Dispatchers.IO) {
            getAllNotesUseCase.getAllNotes().collect {
                when(it){
                    is Resource.Error -> {
                        _notesState.value = UIState.Error(it.message?: "Error")
                    }
                    is Resource.Loading -> {
                        _notesState.value = UIState.Loading()
                    }
                    is Resource.Success -> {
                        if (it.data != null) {
                            _notesState.value = UIState.Success(it.data)
                        }
                    }
                }
            }
        }
    }
}