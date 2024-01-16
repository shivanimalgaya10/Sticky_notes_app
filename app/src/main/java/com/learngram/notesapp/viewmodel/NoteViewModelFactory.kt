package com.learngram.notesapp.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.learngram.notesapp.repository.NoteRepository

//this class intantiate and return viewmodel
class NoteViewModelFactory (val app:Application,private val noteRepository: NoteRepository):ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return NoteViewModel(app,noteRepository) as T
    }
}