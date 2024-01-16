package com.learngram.notesapp.repository

import androidx.room.Query
import com.learngram.notesapp.database.NoteDatabase
import com.learngram.notesapp.model.Note

class NoteRepository(private val db:NoteDatabase) {

    suspend fun insertNote(note: Note)=db.getNoteDao().insertNote(note)
    suspend fun updateNote(note: Note)=db.getNoteDao().updateNote(note)
    suspend fun deleteNote(note: Note)=db.getNoteDao().deleteNote(note)

    fun getAllNotes() = db.getNoteDao().getAllNotes()
    fun searchNote(query: String?)=db.getNoteDao().searchNote(query)
}