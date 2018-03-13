package com.example.mazena.quicknotes.editNote

import com.example.mazena.quicknotes.data.Note

interface EditNoteContract {
    interface View {
        fun displayNote(note: Note)

    }

    interface Presenter {
        fun loadNote(id: Int)

        fun saveNote(updatedTitle: String, updatedDescription: String)
    }
}
