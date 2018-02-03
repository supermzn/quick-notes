package com.example.mazena.quicknotes.notes

import com.example.mazena.quicknotes.data.Note

/**
 * Created by mazena on 28.01.18.
 */
interface NotesContract {
    interface View {
        fun showNotes(notesList: List<Note>)
    }

    interface Preseneter {
        fun loadNotes()

        fun attachView(notesActivity: NotesActivity)

        fun detachView()

    }
}