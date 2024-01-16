package com.learngram.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Query
import com.learngram.notesapp.model.Note
import com.learngram.notesapp.repository.NoteRepository
import kotlinx.coroutines.launch

//class between view and model
class NoteViewModel (app:Application,private val noteRepository: NoteRepository):AndroidViewModel(app){

    fun addNote(note: Note)=
        viewModelScope.launch {
            noteRepository.insertNote(note)
        }
    fun deleteNote(note: Note)=
        viewModelScope.launch {
            noteRepository.deleteNote(note)
        }
    fun updateNote(note: Note)=
        viewModelScope.launch {
            noteRepository.updateNote(note)
        }

    fun getAllNotes()=noteRepository.getAllNotes()

    fun searchNote(query: String?)=
        noteRepository.searchNote(query)
    }
