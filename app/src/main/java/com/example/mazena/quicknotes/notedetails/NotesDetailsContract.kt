package com.example.mazena.quicknotes.notedetails

import com.example.mazena.quicknotes.data.Note

/**
 * Created by mazena on 28.01.18.
 */
interface NotesDetailsContract {
    interface View {
        fun showNote(note: Note)

        fun showError(errorMessage: String)

        fun closeDetails()
    }

    interface Presenter {

        fun loadNote(id: Int)

        fun onNoteDelete()

        fun onEdit()

    }
}