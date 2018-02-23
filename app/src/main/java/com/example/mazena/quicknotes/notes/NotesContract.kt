package com.example.mazena.quicknotes.notes

import android.content.Context
import com.example.mazena.quicknotes.data.Note

/**
 * Created by mazena on 28.01.18.
 */
interface NotesContract {
    interface View {
        fun showNotes(notesList: List<Note>)

        fun showAddNote()
    }

    interface Presenter {
        fun loadNotes()

        fun addNote()
    }
}