package com.example.mazena.quicknotes.notedetails

import android.content.Context
import com.example.mazena.quicknotes.data.Note

/**
 * Created by mazena on 28.01.18.
 */
interface NotesDetailsContract {
    interface View {
        fun showNote(note: Note)

        fun showError(errorMessage: String)
    }

    interface Presenter {

        fun loadNote(id: Int)

    }
}